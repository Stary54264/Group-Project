package interface_adapter.getApiQuestions;

import interface_adapter.ViewManagerModel;
import interface_adapter.takeQuiz.takeQuizViewModel;
import use_cases.getApiQuestions.GetApiQuestionsOutputBoundary;
import use_cases.getApiQuestions.GetApiQuestionsOutputData;

public class GetApiQuestionsPresenter implements GetApiQuestionsOutputBoundary {
    private final GetApiQuestionsViewModel getApiQuestionsViewModel;
    public GetApiQuestionsPresenter(GetApiQuestionsViewModel getApiQuestionsViewModel) {
        this.getApiQuestionsViewModel = getApiQuestionsViewModel;
    }

    @Override
    public void prepareSuccessView(GetApiQuestionsOutputData response) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
