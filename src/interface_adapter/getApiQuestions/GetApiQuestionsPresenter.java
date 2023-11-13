package src.interface_adapter.getApiQuestions;

import src.use_cases.getApiQuestions.GetApiQuestionsOutputBoundary;
import src.use_cases.getApiQuestions.GetApiQuestionsOutputData;

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
