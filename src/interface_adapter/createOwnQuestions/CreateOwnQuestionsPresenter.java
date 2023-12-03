package interface_adapter.createOwnQuestions;

import interface_adapter.ViewManagerModel;
import use_cases.createOwnQuestions.CreateOwnQuestionsOutputBoundary;
import use_cases.createOwnQuestions.CreateOwnQuestionsOutputData;

public class CreateOwnQuestionsPresenter implements CreateOwnQuestionsOutputBoundary {
    private final CreateOwnQuestionsViewModel questionsViewModel;
    private final ViewManagerModel viewManagerModel;
    public CreateOwnQuestionsPresenter(ViewManagerModel viewManagerModel, CreateOwnQuestionsViewModel questionsViewModel) {
        this.questionsViewModel = questionsViewModel;
        this.viewManagerModel = viewManagerModel;
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

    @Override
    public void prepareEditState(CreateOwnQuestionsOutputData output) {
        CreateOwnQuestionsState curr = new CreateOwnQuestionsState(output.getName(), output.getComment(), output.getQuestionBuilders());
        questionsViewModel.setState(curr);
        questionsViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(questionsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
