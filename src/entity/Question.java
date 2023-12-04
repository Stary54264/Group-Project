package entity;

import java.util.ArrayList;

public interface Question<T> {
    T getQuestion();
    void setQuestion(T s);

    T getCorrectAnswer();

    ArrayList<T> getIncorrectAnswers();

    ArrayList<T> getAnswers();
}
