package interface_adapter.takeQuiz;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class takeQuizViewModel extends ViewModel {

    private takeQuizState state;
    public takeQuizState getState() {
        return state;
    }

    public void setState(takeQuizState state) {
        this.state = state;
    }
    public takeQuizViewModel() {
        super("Take Quiz");
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
