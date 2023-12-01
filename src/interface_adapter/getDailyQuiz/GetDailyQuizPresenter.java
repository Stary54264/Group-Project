package interface_adapter.getDailyQuiz;

import use_cases.getApiQuestions.GetApiQuestionsOutputBoundary;
import use_cases.getApiQuestions.GetApiQuestionsOutputData;
import use_cases.getDailyQuiz.GetDailyQuizOutputBoundary;
import use_cases.getDailyQuiz.GetDailyQuizOutputData;

public class GetDailyQuizPresenter implements GetDailyQuizOutputBoundary {
    private final GetDailyQuizViewModel viewModel;
    public GetDailyQuizPresenter(GetDailyQuizViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(GetDailyQuizOutputData response) {
        GetDailyQuizState state = new GetDailyQuizState();
        state.setDailyTest(response.getTestName());
        viewModel.setState(state);
    }
}
