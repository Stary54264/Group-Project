package entity;

import java.util.ArrayList;

public interface QuestionFactory {
    Question create(String question, String correctAnswer, ArrayList<String> incorrectAnswers);
}
