package entity;

import java.util.ArrayList;

public interface Question<Q, A> {
    Q getQuestion();
    void setQuestion(Q s);

    A getCorrectAnswer();

    ArrayList<A> getIncorrectAnswers();

    ArrayList<A> getAnswers();
}
