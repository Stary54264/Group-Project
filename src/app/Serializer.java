package app;

import entity.Question;
import entity.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Serializer {
    public static ArrayList<Question> ParseTrivia(String inp) {
        final String regex = "\\{\\\"type\\\":\\\"(multiple|boolean)\\\",.*?\\\"question\\\":\\\"(.*?)\\\",\\\"correct_answer\\\":\\\"(.*?)\\\",\\\"incorrect_answers\\\":\\[\\\"(.*?)\\\"(?:, ?\\\"(.*?)\\\", ?\\\"(.*?)\\\")?\\]\\}";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(inp);
        ArrayList<Question> out = new ArrayList<>();

        while (matcher.find()) {
            QuestionBuilder qb = new QuestionBuilder();

            qb.setCorrectAnswer(matcher.group(3));
            qb.setQuestionText(matcher.group(2));
            String type = matcher.group(1);
            if (type.equals("multiple")) {
                qb.setIncorrectAnswers(new ArrayList<>(Arrays.asList(matcher.group(4), matcher.group(5), matcher.group(6))));
            } else {
                qb.setIncorrectAnswers(new ArrayList<>(Collections.singletonList(matcher.group(4))));
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
            qb.setCorrectAnswer(matcher.group(1));
            qb.setIncorrectAnswers(new ArrayList<>(Arrays.asList(matcher.group(2), matcher.group(3), matcher.group(4))));
            qb.setQuestionText(matcher.group(5));
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

        if (!stats.isEmpty()) tb.setStats(stats);
        System.out.println(stats.isEmpty());
        System.out.println(stats);

        return tb.build();
    }

    public static String EncodeTest(Test inp) {
        System.out.println(inp.getQuestions());
        StringBuilder out = new StringBuilder();
        for (Question q: inp.getQuestions()) {
            String s = "{";
            if (q.getIncorrectAnswers().size() == 1) s += "\"type\":\"boolean\"";
            else s += "\"type\":\"multiple\",";
            s += "\"question\":\""+q.getQuestion()+"\",";
            s += "\"correct_answer\":\""+q.getCorrectAnswer()+"\",";
            s += "\"incorrect_answers\":[\""+String.join("\", \"", q.getIncorrectAnswers())+"\"]";
            s += "}";
            System.out.println(String.join("\", \"", q.getIncorrectAnswers()));
            out.append(s);
        }
        out.append("\"comment\":\"").append(inp.getComment()).append("\"");
        out.append("\"stats\":\"").append(inp.getStats()).append("\"");
        System.out.println(inp.getStats());
        return out.toString();
    }
}
