package interface_adapter.takeQuiz;

import interface_adapter.ViewManagerModel;
import interface_adapter.getResult.GetResultViewModel;
import use_cases.takeQuiz.takeQuizOutputBoundary;
import use_cases.takeQuiz.takeQuizOutputData;

import java.util.ArrayList;
import java.util.Collections;

public class takeQuizPresenter implements takeQuizOutputBoundary {
    private final takeQuizViewModel viewModel;
    private final GetResultViewModel resultviewModel;
    private final ViewManagerModel viewManagerModel;

    public takeQuizPresenter(takeQuizViewModel viewModel, GetResultViewModel resultviewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.resultviewModel = resultviewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareNextQuestion(takeQuizOutputData data) {
        takeQuizState state = new takeQuizState();
        state.setFinished(false);
        state.setQuestion(data.question());
        ArrayList<String> answers = data.answers();
        Collections.shuffle(answers);
        state.setAnswers(answers.toArray(new String[0]));
        String testName = data.testName();
        if (testName != null) state.setTestName(testName);
        state.setLastAnswer(data.lastAnswer());
        state.setLastCorrect(data.lastCorrect());

        viewModel.setState(state);
        viewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(viewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareResultView(String name) {
        viewModel.getState().setFinished(true);
        viewModel.getState().setTestName(name);
        viewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(resultviewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
