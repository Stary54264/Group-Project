package app;

import entity.Question;
import entity.Test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Serializer {
    /** Prevent instantiation. */
    private Serializer() {}

    public static ArrayList<Question> ParseTrivia(String inp) {
        final String regex = "\\{\"type\":\"(multiple|boolean)\",.*?\"question\":\"(.*?)\",\"correct_answer\":\"(.*?)\",\"incorrect_answers\":\\[\"(.*?)\"(?:, ?\"(.*?)\", ?\"(.*?)\")?]\\}";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(inp);
        ArrayList<Question> out = new ArrayList<>();

        while (matcher.find()) {
            QuestionBuilder qb = new QuestionBuilder();

            qb.setCorrectAnswer(StringUtils.unescapeHtml3(matcher.group(3)));
            qb.setQuestionText(StringUtils.unescapeHtml3(matcher.group(2)));
            String type = matcher.group(1);
            if (type.equals("multiple")) {
                qb.setIncorrectAnswers(new ArrayList<>(Arrays.asList(
                        StringUtils.unescapeHtml3(matcher.group(4)),
                        StringUtils.unescapeHtml3(matcher.group(5)),
                        StringUtils.unescapeHtml3(matcher.group(6))
                )));
            } else {
                qb.setIncorrectAnswers(new ArrayList<>(Collections.singletonList(StringUtils.unescapeHtml3(matcher.group(4)))));
            }
            out.add(qb.build());
        }

        return out;
    }

    public static ArrayList<Question> ParseTrivia2(String inp) {
        final String regex = "\"correctAnswer\":\"(.*?)\",\"incorrectAnswers\":\\[\"(.*?)\",\"(.*?)\",\"(.*?)\"],\"question\":\\{\"text\":\"(.*?)\"";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(inp);
        ArrayList<Question> out = new ArrayList<>();

        while (matcher.find()) {
            QuestionBuilder qb = new QuestionBuilder();
            qb.setCorrectAnswer(StringUtils.unescapeHtml3(matcher.group(1)));
            qb.setIncorrectAnswers(new ArrayList<>(Arrays.asList(
                    StringUtils.unescapeHtml3(matcher.group(2)),
                    StringUtils.unescapeHtml3(matcher.group(3)),
                    StringUtils.unescapeHtml3(matcher.group(4))
            )));
            qb.setQuestionText(StringUtils.unescapeHtml3(matcher.group(5)));
            out.add(qb.build());
        }

        return out;
    }

    public static Test DecodeTest(String input, String name) {
        ArrayList<Question> questions = ParseTrivia(input);
        final String comReg = "\"comment\":\"(.*?)\"";
        final Pattern pattern = Pattern.compile(comReg, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(input);
        String comment;
        if (matcher.find()) {
            comment = matcher.group(1);
        } else comment = "";

        final String statsReg = "\"stats\":\"(.*?)\"";
        final Pattern pattern2 = Pattern.compile(statsReg, Pattern.MULTILINE);
        final Matcher matcher2 = pattern2.matcher(input);

        String stats;
        if (matcher2.find()) {
            stats = matcher2.group(1);
        } else stats = "";
        TestBuilder tb = new TestBuilder().setQuestions(questions).setName(name).setCategory("Any").setComment(comment);

        if (!stats.isEmpty() && !stats.equals("null")) tb.setStats(stats);

        return tb.build();
    }

    public static String EncodeTest(Test inp) {
        StringBuilder out = new StringBuilder();
        for (Question q: inp.getQuestions()) {
            String s = "{";
            if (q.getIncorrectAnswers().size() == 1) s += "\"type\":\"boolean\",";
            else s += "\"type\":\"multiple\",";
            s += "\"question\":\""+q.getQuestion()+"\",";
            s += "\"correct_answer\":\""+q.getCorrectAnswer()+"\",";
            s += "\"incorrect_answers\":[\""+String.join("\", \"", q.getIncorrectAnswers())+"\"]";
            s += "}";
            out.append(s);
        }
        out.append("\"comment\":\"").append(inp.getComment()).append("\"");
        out.append("\"stats\":\"").append(inp.getStats()).append("\"");
        return out.toString();
    }

    private static class StringUtils {

        public static String unescapeHtml3(final String input) {
            StringWriter writer = null;
            int len = input.length();
            int i = 1;
            int st = 0;
            while (true) {
                // Look for '&'
                while (i < len && input.charAt(i-1) != '&')
                    i++;
                if (i >= len)
                    break;

                // Found '&', look for ';'
                int j = i;
                while (j < len && j < i + MAX_ESCAPE + 1 && input.charAt(j) != ';')
                    j++;
                if (j == len || j < i + MIN_ESCAPE || j == i + MAX_ESCAPE + 1) {
                    i++;
                    continue;
                }

                // Found escape
                if (input.charAt(i) == '#') {
                    // Numeric escape
                    int k = i + 1;
                    int radix = 10;

                    final char firstChar = input.charAt(k);
                    if (firstChar == 'x' || firstChar == 'X') {
                        k++;
                        radix = 16;
                    }

                    try {
                        int entityValue = Integer.parseInt(input.substring(k, j), radix);

                        if (writer == null)
                            writer = new StringWriter(input.length());
                        writer.append(input.substring(st, i - 1));

                        if (entityValue > 0xFFFF) {
                            final char[] chrs = Character.toChars(entityValue);
                            writer.write(chrs[0]);
                            writer.write(chrs[1]);
                        } else {
                            writer.write(entityValue);
                        }

                    } catch (NumberFormatException ex) {
                        i++;
                        continue;
                    }
                }
                else {
                    // Named escape
                    CharSequence value = lookupMap.get(input.substring(i, j));
                    if (value == null) {
                        i++;
                        continue;
                    }

                    if (writer == null)
                        writer = new StringWriter(input.length());
                    writer.append(input.substring(st, i - 1));

                    writer.append(value);
                }

                // Skip escape
                st = j + 1;
                i = st;
            }

            if (writer != null) {
                writer.append(input.substring(st, len));
                return writer.toString();
            }
            return input;
        }

        private static final String[][] ESCAPES = {
                {"\"",     "quot"}, // " - double-quote
                {"&",      "amp"}, // & - ampersand
                {"<",      "lt"}, // < - less-than
                {">",      "gt"}, // > - greater-than

                // Mapping to escape ISO-8859-1 characters to their named HTML 3.x equivalents.
                {"\u00A0", "nbsp"},   // Non-breaking space
                {"¡", "iexcl"},  // Inverted exclamation mark
                {"¢", "cent"},   // Cent sign
                {"£", "pound"},  // Pound sign
                {"¤", "curren"}, // Currency sign
                {"¥", "yen"},    // Yen sign = yuan sign
                {"¦", "brvbar"}, // Broken bar = broken vertical bar
                {"§", "sect"},   // Section sign
                {"¨", "uml"},    // Diaeresis = spacing diaeresis
                {"©", "copy"},   // © - copyright sign
                {"ª", "ordf"},   // Feminine ordinal indicator
                {"«", "laquo"},  // Left-pointing double angle quotation mark = left pointing guillemet
                {"¬", "not"},    // Not sign
                {"\u00AD", "shy"},    // Soft hyphen = discretionary hyphen
                {"®", "reg"},    // ® - registered trademark sign
                {"¯", "macr"},   // Macron = spacing macron = overline = APL overbar
                {"°", "deg"},    // Degree sign
                {"±", "plusmn"}, // Plus-minus sign = plus-or-minus sign
                {"²", "sup2"},   // Superscript two = superscript digit two = squared
                {"³", "sup3"},   // Superscript three = superscript digit three = cubed
                {"´", "acute"},  // Acute accent = spacing acute
                {"µ", "micro"},  // Micro sign
                {"¶", "para"},   // Pilcrow sign = paragraph sign
                {"·", "middot"}, // Middle dot = Georgian comma = Greek middle dot
                {"¸", "cedil"},  // Cedilla = spacing cedilla
                {"¹", "sup1"},   // Superscript one = superscript digit one
                {"º", "ordm"},   // Masculine ordinal indicator
                {"»", "raquo"},  // Right-pointing double angle quotation mark = right pointing guillemet
                {"¼", "frac14"}, // Vulgar fraction one quarter = fraction one quarter
                {"½", "frac12"}, // Vulgar fraction one half = fraction one half
                {"¾", "frac34"}, // Vulgar fraction three quarters = fraction three quarters
                {"¿", "iquest"}, // Inverted question mark = turned question mark
                {"À", "Agrave"}, // А - uppercase A, grave accent
                {"Á", "Aacute"}, // Б - uppercase A, acute accent
                {"Â", "Acirc"},  // В - uppercase A, circumflex accent
                {"Ã", "Atilde"}, // Г - uppercase A, tilde
                {"Ä", "Auml"},   // Д - uppercase A, umlaut
                {"Å", "Aring"},  // Е - uppercase A, ring
                {"Æ", "AElig"},  // Ж - uppercase AE
                {"Ç", "Ccedil"}, // З - uppercase C, cedilla
                {"È", "Egrave"}, // И - uppercase E, grave accent
                {"É", "Eacute"}, // Й - uppercase E, acute accent
                {"Ê", "Ecirc"},  // К - uppercase E, circumflex accent
                {"Ë", "Euml"},   // Л - uppercase E, umlaut
                {"Ì", "Igrave"}, // М - uppercase I, grave accent
                {"Í", "Iacute"}, // Н - uppercase I, acute accent
                {"Î", "Icirc"},  // О - uppercase I, circumflex accent
                {"Ï", "Iuml"},   // П - uppercase I, umlaut
                {"Ð", "ETH"},    // Р - uppercase Eth, Icelandic
                {"Ñ", "Ntilde"}, // С - uppercase N, tilde
                {"Ò", "Ograve"}, // Т - uppercase O, grave accent
                {"Ó", "Oacute"}, // У - uppercase O, acute accent
                {"Ô", "Ocirc"},  // Ф - uppercase O, circumflex accent
                {"Õ", "Otilde"}, // Х - uppercase O, tilde
                {"Ö", "Ouml"},   // Ц - uppercase O, umlaut
                {"×", "times"},  // Multiplication sign
                {"Ø", "Oslash"}, // Ш - uppercase O, slash
                {"Ù", "Ugrave"}, // Щ - uppercase U, grave accent
                {"Ú", "Uacute"}, // Ъ - uppercase U, acute accent
                {"Û", "Ucirc"},  // Ы - uppercase U, circumflex accent
                {"Ü", "Uuml"},   // Ь - uppercase U, umlaut
                {"Ý", "Yacute"}, // Э - uppercase Y, acute accent
                {"Þ", "THORN"},  // Ю - uppercase THORN, Icelandic
                {"ß", "szlig"},  // Я - lowercase sharps, German
                {"à", "agrave"}, // а - lowercase a, grave accent
                {"á", "aacute"}, // б - lowercase a, acute accent
                {"â", "acirc"},  // в - lowercase a, circumflex accent
                {"ã", "atilde"}, // г - lowercase a, tilde
                {"ä", "auml"},   // д - lowercase a, umlaut
                {"å", "aring"},  // е - lowercase a, ring
                {"æ", "aelig"},  // ж - lowercase ae
                {"ç", "ccedil"}, // з - lowercase c, cedilla
                {"è", "egrave"}, // и - lowercase e, grave accent
                {"é", "eacute"}, // й - lowercase e, acute accent
                {"ê", "ecirc"},  // к - lowercase e, circumflex accent
                {"ë", "euml"},   // л - lowercase e, umlaut
                {"ì", "igrave"}, // м - lowercase i, grave accent
                {"í", "iacute"}, // н - lowercase i, acute accent
                {"î", "icirc"},  // о - lowercase i, circumflex accent
                {"ï", "iuml"},   // п - lowercase i, umlaut
                {"ð", "eth"},    // р - lowercase eth, Icelandic
                {"ñ", "ntilde"}, // с - lowercase n, tilde
                {"ò", "ograve"}, // т - lowercase o, grave accent
                {"ó", "oacute"}, // у - lowercase o, acute accent
                {"ô", "ocirc"},  // ф - lowercase o, circumflex accent
                {"õ", "otilde"}, // х - lowercase o, tilde
                {"ö", "ouml"},   // ц - lowercase o, umlaut
                {"÷", "divide"}, // Division sign
                {"ø", "oslash"}, // ш - lowercase o, slash
                {"ù", "ugrave"}, // щ - lowercase u, grave accent
                {"ú", "uacute"}, // ъ - lowercase u, acute accent
                {"û", "ucirc"},  // ы - lowercase u, circumflex accent
                {"ü", "uuml"},   // ь - lowercase u, umlaut
                {"ý", "yacute"}, // э - lowercase y, acute accent
                {"þ", "thorn"},  // ю - lowercase thorn, Icelandic
                {"ÿ", "yuml"},   // я - lowercase y, umlaut
        };

        private static final int MIN_ESCAPE = 2;
        private static final int MAX_ESCAPE = 6;

        private static final HashMap<String, CharSequence> lookupMap;
        static {
            lookupMap = new HashMap<>();
            for (final CharSequence[] seq : ESCAPES)
                lookupMap.put(seq[1].toString(), seq[0]);
        }

    }
}
