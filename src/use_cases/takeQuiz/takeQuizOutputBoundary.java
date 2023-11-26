package use_cases.takeQuiz;

import entity.Result;
import entity.Test;

public interface takeQuizOutputBoundary {

    void prepareFailed();
    void prepareNextQuestion(takeQuizOutputData data);

    void prepareResultView(String name);
}
