package interface_adapter.createOwnQuestions;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateOwnQuestionsViewModel extends ViewModel {
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public static final String TITLE_LABEL = "Create Questions";
    public static final String FINISHED_BUTTON_LABEL = "Finish";
    public static final String NEXT_BUTTON_LABEL = "Next";
    public static final String QUESTION_LABEL = "Question: ";
    public static final String ANSWER_LABEL = "Answer: ";
    public static final String INCORRECT_LABEL = "Incorrect answer: ";
    private CreateOwnQuestionsState questionsState = new CreateOwnQuestionsState();

    public CreateOwnQuestionsViewModel() {
        super("Create Questions");
    }

    public void setState(CreateOwnQuestionsState questionsState) {
        this.questionsState = questionsState;
    }

    public CreateOwnQuestionsState getState() {
        return this.questionsState;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.questionsState);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}