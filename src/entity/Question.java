package src.entity;

import java.util.ArrayList;

public class Question {
    private String question;
    private String correctAnswer;
    private ArrayList<String> incorrectAnswers;

    public Question(String question, String correctAnswer, ArrayList<String> incorrectAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setIncorrectAnswers(ArrayList<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getQuestion() {
        return question;
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
