package interface_adapter.manageQuiz;

import java.util.Map;

public class manageQuizState {
    private Map<String, String> state;

    public void setTests(Map<String, String> state) {
        this.state = state;
    }

    public Map<String, String> getTests() {
        return state;
    }
}
