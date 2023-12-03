package entity;

import java.util.ArrayList;

public class Question {
    private String question;
    private final String correctAnswer;
    private final ArrayList<String> incorrectAnswers;

    public Question(String question, String correctAnswer, ArrayList<String> incorrectAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String s) {
        question = s;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public ArrayList<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public ArrayList<String> getAnswers() {
        ArrayList<String> q = new ArrayList<>(1);
        q.add(correctAnswer);
        q.addAll(incorrectAnswers);
        return q;
    }
}
