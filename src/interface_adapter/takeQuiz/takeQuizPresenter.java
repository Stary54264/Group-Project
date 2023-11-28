package interface_adapter.takeQuiz;

import use_cases.takeQuiz.takeQuizOutputBoundary;
import use_cases.takeQuiz.takeQuizOutputData;

public class takeQuizPresenter implements takeQuizOutputBoundary {
    private final takeQuizViewModel viewModel;

    public takeQuizPresenter(takeQuizViewModel viewModel) {
        this.viewModel = viewModel;
    }

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
