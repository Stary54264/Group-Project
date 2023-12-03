package interface_adapter.getApiQuestions;

import interface_adapter.takeQuiz.takeQuizState;
import interface_adapter.takeQuiz.takeQuizViewModel;
import use_cases.getApiQuestions.GetApiQuestionsOutputBoundary;
import use_cases.getApiQuestions.GetApiQuestionsOutputData;

public class GetApiQuestionsPresenter implements GetApiQuestionsOutputBoundary {
    private final GetApiQuestionsViewModel getApiQuestionsViewModel;
    private final takeQuizViewModel quizViewModel;

    public GetApiQuestionsPresenter(GetApiQuestionsViewModel getApiQuestionsViewModel,
                                    takeQuizViewModel quizViewModel) {
        this.getApiQuestionsViewModel = getApiQuestionsViewModel;
        this.quizViewModel = quizViewModel;
    }

    @Override
    public void prepareSuccessView(GetApiQuestionsOutputData response) {
        // On success, switch to the take quiz view.
        GetApiQuestionsState state = getApiQuestionsViewModel.getState();
        state.setTestName(response.getTestName());
        this.getApiQuestionsViewModel.setState(state);
        getApiQuestionsViewModel.firePropertyChanged();

        //Example: sign up view - On success, switch to the login test.view.
        takeQuizState quizState = new takeQuizState();
        quizState.setTestName(response.getTestName());
        this.quizViewModel.setState(quizState);
        quizViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        GetApiQuestionsState getApiQuestionsState = getApiQuestionsViewModel.getState();
        getApiQuestionsState.setTestNameError(error);
        getApiQuestionsViewModel.firePropertyChanged();
    }
}
