package interface_adapter.manageQuiz;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class manageQuizViewModel extends ViewModel {
    private manageQuizState state = new manageQuizState();
    public manageQuizViewModel() {
        super("Main Menu");
    }
    public void setState(manageQuizState state) {
        this.state = state;
    }
    public manageQuizState getState() {
        return state;
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
}
