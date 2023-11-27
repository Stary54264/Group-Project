package app;
import entity.Question;

import java.util.ArrayList;

public class QuestionBuilder {
    private Question question;
    private String questionText, correctAnswer;
    private ArrayList<String> incorrectAnswers;
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    public void setIncorrectAnswers(ArrayList<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
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
    public Question Build() {
        question.setQuestion(questionText);
        question.setCorrectAnswer(correctAnswer);
        question.setIncorrectAnswers(incorrectAnswers);
        return question;
    }
}
