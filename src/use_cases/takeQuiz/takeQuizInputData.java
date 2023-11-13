package use_cases.takeQuiz;

import src.entity.Question;
import src.entity.Test;

import java.util.ArrayList;

public class takeQuizInputData{
    private final String userAnswer;
    public takeQuizInputData(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }
}
