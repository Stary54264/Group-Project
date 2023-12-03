package interface_adapter.manageQuiz;

import java.util.Map;

public class manageQuizState {
    private Map<String, String[]> tests;

    public void setTests(Map<String, String[]> tests) {
        this.tests = tests;
    }

    public Map<String, String[]> getTests() {
        return tests;
    }
}
