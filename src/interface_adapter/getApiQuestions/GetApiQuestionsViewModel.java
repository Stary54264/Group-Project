package interface_adapter.getApiQuestions;

import app.QuestionDifficulty;
import app.QuestionType;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class GetApiQuestionsViewModel extends ViewModel {
    public static final String NAME_LABEL = "Test Name: ";
    public static final String NUMBER_LABEL = "Number of Questions: ";
    public static final String CATEGORY_LABEL = "Choose Category: ";
    public static final String TYPE_LABEL = "Choose Type: ";
    public static final String DIFF_LABEL = "Choose Difficulty: ";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public static final String QUIZ_LABEL = "Take Quiz";

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
