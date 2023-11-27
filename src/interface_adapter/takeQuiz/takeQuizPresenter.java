package interface_adapter.takeQuiz;

import entity.Result;
import entity.Test;
import use_cases.takeQuiz.takeQuizOutputBoundary;
import use_cases.takeQuiz.takeQuizOutputData;

public class takeQuizPresenter implements takeQuizOutputBoundary {
    @Override
    public void prepareFailed() {

    }

    @Override
    public void prepareNextQuestion(takeQuizOutputData data) {

    }

    @Override
    public void prepareResultView(String name) {

    }
}
