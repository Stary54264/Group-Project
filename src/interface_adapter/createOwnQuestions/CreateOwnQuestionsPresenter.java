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
        CreateOwnQuestionsState currState = new CreateOwnQuestionsState(output);
        questionsViewModel.setState(currState);
    }
}
