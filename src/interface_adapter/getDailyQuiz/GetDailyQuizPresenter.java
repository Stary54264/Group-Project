package interface_adapter.getDailyQuiz;

import use_cases.getApiQuestions.GetApiQuestionsOutputBoundary;
import use_cases.getApiQuestions.GetApiQuestionsOutputData;

public class GetDailyQuizPresenter implements GetApiQuestionsOutputBoundary {

    // needs view models
    public GetDailyQuizPresenter() {}

    @Override
    public void prepareSuccessView(GetApiQuestionsOutputData response) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
