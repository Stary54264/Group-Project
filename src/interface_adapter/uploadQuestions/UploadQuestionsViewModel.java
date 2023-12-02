package interface_adapter.uploadQuestions;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UploadQuestionsViewModel extends ViewModel {
    public static final String TEST_NAME_LABEL = "Enter the name for your test: ";
    public static final String TXT_PATH_LABEL = "Enter the path for  your test file: ";
    public static final String UPLOAD_BUTTON_LABEL = "Upload";
    private UploadQuestionsState uploadQuestionsState = new UploadQuestionsState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public UploadQuestionsViewModel() {
        super("upload questions");
    }

    public void setState(UploadQuestionsState uploadQuestionsState) {
        this.uploadQuestionsState = uploadQuestionsState;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.uploadQuestionsState);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public UploadQuestionsState getState() {
        return uploadQuestionsState;
    }
}
