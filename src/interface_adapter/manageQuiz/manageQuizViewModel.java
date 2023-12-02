package interface_adapter.manageQuiz;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

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

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
