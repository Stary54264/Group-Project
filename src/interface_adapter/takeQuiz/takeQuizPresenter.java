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
        takeQuizState state = new takeQuizState();
        state.setFinished(false);
        state.setQuestion(data.getQuestion());
        state.setAnswers(data.getAnswers().toArray(new String[0]));
        String testName = data.getTestName();
        if (testName != null) state.setTestName(testName);
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareResultView(String name) {
        viewModel.getState().setFinished(true);
        viewModel.firePropertyChanged();
    }
}
