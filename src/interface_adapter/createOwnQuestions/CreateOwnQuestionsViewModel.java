package interface_adapter.createOwnQuestions;

import entity.Question;
import interface_adapter.ViewModel;
import use_cases.createOwnQuestions.CreateOwnQuestionsOutputData;

import java.beans.PropertyChangeListener;
import java.util.List;

public class CreateOwnQuestionsViewModel extends ViewModel {
    private List<Question> defaultQuestionList;
    private CreateOwnQuestionsState questionsState = new CreateOwnQuestionsState(new CreateOwnQuestionsOutputData(defaultQuestionList));

    public CreateOwnQuestionsViewModel() {
        super("questions");
    }

    public void setState(CreateOwnQuestionsState questionsState) {
        this.questionsState = questionsState;
    }

    public CreateOwnQuestionsState getState() {
        return this.questionsState;
    }
    @Override
    public void firePropertyChanged() {

    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}