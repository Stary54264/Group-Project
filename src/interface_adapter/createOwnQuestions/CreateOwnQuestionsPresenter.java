package interface_adapter.createOwnQuestions;

import use_cases.createOwnQuestions.CreateOwnQuestionsOutputBoundary;
import use_cases.createOwnQuestions.CreateOwnQuestionsOutputData;

public class CreateOwnQuestionsPresenter implements CreateOwnQuestionsOutputBoundary {
    private CreateOwnQuestionsViewModel questionsViewModel;
    public CreateOwnQuestionsPresenter(CreateOwnQuestionsViewModel questionsViewModel) {
        this.questionsViewModel = questionsViewModel;
    }


    @Override
    public void prepareSuccessView(CreateOwnQuestionsOutputData output) {
        CreateOwnQuestionsState curr = questionsViewModel.getState();
        if (output.getQuestionList().contains(null)) {
            curr.setError("Failed to create a test.");
        }
        questionsViewModel.setState(curr);
    }
    @Override
    public void prepareFailView() {
        CreateOwnQuestionsState curr = questionsViewModel.getState();
        curr.setError("Failed to create a test.");
        questionsViewModel.setState(curr);
        questionsViewModel.firePropertyChanged();
    }
}
