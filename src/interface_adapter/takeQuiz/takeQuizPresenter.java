package src.interface_adapter.takeQuiz;

import src.entity.Result;
import src.entity.Test;
import src.use_cases.takeQuiz.takeQuizOutputBoundary;
import src.use_cases.takeQuiz.takeQuizOutputData;

public class takeQuizPresenter implements takeQuizOutputBoundary {
    @Override
    public void prepareFailed() {

    }

    @Override
    public void prepareNextQuestion(takeQuizOutputData data) {

    }

    @Override
    public void prepareResultView(Test test, Result result) {

    }
}
