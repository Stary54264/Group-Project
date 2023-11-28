package interface_adapter.getDailyQuiz;

import use_cases.getApiQuestions.GetApiQuestionsOutputBoundary;
import use_cases.getApiQuestions.GetApiQuestionsOutputData;

public class GetDailyQuizPresenter implements GetApiQuestionsOutputBoundary {
    private final GetDailyQuizViewModel viewModel;
    public GetDailyQuizPresenter(GetDailyQuizViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(GetApiQuestionsOutputData response) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
