package app;
import entity.TextQuestion;

import java.util.ArrayList;

public class TextQuestionBuilder {
    private String questionText, correctAnswer;
    private ArrayList<String> incorrectAnswers;
    public TextQuestionBuilder setQuestionText(String questionText) {
        this.questionText = questionText;
        return this;
    }
    public TextQuestionBuilder setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }
    public TextQuestionBuilder setIncorrectAnswers(ArrayList<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
        return this;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public ArrayList<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public TextQuestionBuilder() {
        incorrectAnswers = new ArrayList<>();
        incorrectAnswers.add(""); incorrectAnswers.add(""); incorrectAnswers.add("");
    }

    public TextQuestion build() {
        if (questionText.isBlank() || correctAnswer.isBlank() || incorrectAnswers.get(0).isBlank()) return null;

        if (incorrectAnswers.size() != 1 && incorrectAnswers.get(2).isBlank() && incorrectAnswers.get(3).isBlank()) {
            incorrectAnswers.remove(3);
            incorrectAnswers.remove(2);
        }
        return new TextQuestion(questionText, correctAnswer, incorrectAnswers);
    }
}
