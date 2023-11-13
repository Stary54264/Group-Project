package interface_adapter.getApiQuestions;

import use_cases.getApiQuestions.GetApiQuestionsOutputBoundary;
import use_cases.getApiQuestions.GetApiQuestionsOutputData;

public class GetApiQuestionsPresenter implements GetApiQuestionsOutputBoundary {

    // needs view models
    public GetApiQuestionsPresenter() {}

    @Override
    public void prepareSuccessView(GetApiQuestionsOutputData response) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
