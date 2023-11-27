package interface_adapter.getResult;
import java.beans.PropertyChangeListener;
import interface_adapter.ViewModel;
import java.beans.PropertyChangeSupport;
public class GetResultViewModel extends ViewModel {

    private GetResultState state = new GetResultState();
    public GetResultViewModel() {super("getResult");}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public GetResultState getState() {
        return state;
    }
    public void setGetResultState(GetResultState getResultState) {
        state = getResultState;
    }
    public String result(){
        return String.join("\n", state.getResult());
    }

}
