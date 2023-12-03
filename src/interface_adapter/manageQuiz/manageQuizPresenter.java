package interface_adapter.manageQuiz;

import use_cases.manageQuiz.manageQuizOutputBoundary;
import use_cases.manageQuiz.manageQuizOutputData;

public class manageQuizPresenter implements manageQuizOutputBoundary {
    private final manageQuizViewModel viewModel;

    public manageQuizPresenter(manageQuizViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void refreshTests(manageQuizOutputData data) {
        viewModel.getState().setTests(data.newTests());
        //viewModel.firePropertyChanged();
    }
}
