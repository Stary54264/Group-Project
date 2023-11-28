package interface_adapter.takeQuiz;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class takeQuizViewModel extends ViewModel {

    public takeQuizState getState() {
        return null; //TODO
    }

    public void setState(takeQuizState state) {

    }
    public takeQuizViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
