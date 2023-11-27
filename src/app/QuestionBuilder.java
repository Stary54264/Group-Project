package app;
import entity.Question;

import java.util.ArrayList;

public class QuestionBuilder {
    private Question question;
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
    public QuestionBuilder() {
        this.question = new Question("", "", new ArrayList<String>());
    }
    public QuestionBuilder(Question q) {
        question = q;
        questionText = q.getQuestion();
        correctAnswer = q.getCorrectAnswer();
        incorrectAnswers = q.getIncorrectAnswers();
    }
    public Question build() {
        if (questionText.isEmpty() || correctAnswer.isEmpty() || incorrectAnswers.contains("")) return null;
        question.setQuestion(questionText);
        question.setCorrectAnswer(correctAnswer);
        question.setIncorrectAnswers(incorrectAnswers);
        return question;
    }
}
