package interface_adapter.EditQuestions;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditQuestionsViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Edit Questions";
    public static final String ENTER_BUTTON_LABEL = "Enter";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public static final String FINISHED_BUTTON_LABEL = "Finish";
    public static final String TESTNAME_LABEL = "Test name: ";
    public static final String QUESTIONNUM_LABEL = "Question number: ";
    public static final String QUESTION_LABEL = "Question: ";
    public static final String ANSWER_LABEL = "Answer: ";
    public static final String INCORRECT_LABEL = "Incorrect answer: ";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private EditQuestionsState editQuestionsState = new EditQuestionsState();
    public EditQuestionsViewModel() {
        super("edit questions");
    }
    public void setState(EditQuestionsState state) {
        this.editQuestionsState = state;
    }
    public EditQuestionsState getState() {
        return this.editQuestionsState;
    }


    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.editQuestionsState);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
