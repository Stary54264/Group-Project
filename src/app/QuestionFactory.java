package app;
import entity.Question;

import java.util.ArrayList;

public class QuestionFactory {
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
    public QuestionFactory() {
        this.question = new Question("", "", new ArrayList<String>());
    }
    public QuestionFactory(Question q) {
        question = q;
        questionText = q.getQuestion();
        correctAnswer = q.getCorrectAnswer();
        incorrectAnswers = q.getIncorrectAnswers();
    }
    public Question Build() {
        //question.set(questionText);
        question.setCorrectAnswer(correctAnswer);
        question.setIncorrectAnswers(incorrectAnswers);
        return question;
    }
}
