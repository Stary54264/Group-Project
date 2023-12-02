package interface_adapter.getApiQuestions;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GetApiQuestionsViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Set Questions";
    public static final String NAME_LABEL = "Test Name: ";
    public static final String NUMBER_LABEL = "Number of Questions: ";
    public static final String CATEGORY_LABEL = "Choose Category: ";
    public static final String TYPE_LABEL = "Choose Type: ";
    public static final String DIFF_LABEL = "Choose Difficulty: ";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public static final String QUIZ_LABEL = "Take Quiz";

    private GetApiQuestionsState state = new GetApiQuestionsState();

    public GetApiQuestionsViewModel() {
        super("get api questions");
    }

    public void setState(GetApiQuestionsState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public GetApiQuestionsState getState() {return state;}
}
