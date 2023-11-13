package src.use_cases.takeQuiz;

import src.entity.Result;
import src.entity.Test;

public interface takeQuizOutputBoundary {

    void prepareFailed();
    void prepareNextQuestion(takeQuizOutputData data);

    void prepareResultView(Test test, Result result);
}
