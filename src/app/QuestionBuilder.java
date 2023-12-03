package app;
import entity.Question;

import java.util.ArrayList;

public class QuestionBuilder {
    private String questionText, correctAnswer;
    private ArrayList<String> incorrectAnswers;
    public QuestionBuilder setQuestionText(String questionText) {
        this.questionText = questionText;
        return this;
    }
    public QuestionBuilder setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }
    public QuestionBuilder setIncorrectAnswers(ArrayList<String> incorrectAnswers) {
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

    public QuestionBuilder() {
        incorrectAnswers = new ArrayList<>();
        incorrectAnswers.add(""); incorrectAnswers.add(""); incorrectAnswers.add("");
    }

    public Question build() {
        if (questionText.isBlank() || correctAnswer.isBlank() || incorrectAnswers.get(0).isBlank()) return null;

        if (incorrectAnswers.size() != 1 && incorrectAnswers.get(2).isBlank() && incorrectAnswers.get(3).isBlank()) {
            incorrectAnswers.remove(3);
            incorrectAnswers.remove(2);
        }
        return new Question(questionText, correctAnswer, incorrectAnswers);
    }
}
