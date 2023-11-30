package interface_adapter.getApiQuestions;

import interface_adapter.ViewManagerModel;
import interface_adapter.takeQuiz.takeQuizViewModel;
import use_cases.getApiQuestions.GetApiQuestionsOutputBoundary;
import use_cases.getApiQuestions.GetApiQuestionsOutputData;

public class GetApiQuestionsPresenter implements GetApiQuestionsOutputBoundary {
    private final GetApiQuestionsViewModel getApiQuestionsViewModel;
    private final takeQuizViewModel quizViewModel;
    private final ViewManagerModel viewManagerModel;

    public GetApiQuestionsPresenter(GetApiQuestionsViewModel getApiQuestionsViewModel,
                                    takeQuizViewModel quizViewModel,
                                    ViewManagerModel viewManagerModel) {
        this.getApiQuestionsViewModel = getApiQuestionsViewModel;
        this.quizViewModel = quizViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(GetApiQuestionsOutputData response) {
        // On success, switch to the take quiz view.
        GetApiQuestionsState state = getApiQuestionsViewModel.getState();
        state.setTestName(response.getTestName());
        this.getApiQuestionsViewModel.setState(state);
        getApiQuestionsViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(getApiQuestionsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        //Example: sign up view - On success, switch to the login test.view.
//        LoginState loginState = loginViewModel.getState();
//        loginState.setUsername(response.getUsername());
//        this.loginViewModel.setState(loginState);
//        loginViewModel.firePropertyChanged();
//        viewManagerModel.setActiveView(loginViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        GetApiQuestionsState getApiQuestionsState = getApiQuestionsViewModel.getState();
        getApiQuestionsState.setTestNameError(error);
        getApiQuestionsViewModel.firePropertyChanged();
    }
}
