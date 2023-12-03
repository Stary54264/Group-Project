package use_cases.manageQuiz;

import entity.Test;

import java.util.List;
import java.util.Map;

public class manageQuizOutputData {
    private final Map<String, String[]> newTests;
    public manageQuizOutputData(Map<String, String[]> newTests) {
        this.newTests = newTests;
    }

    public Map<String, String[]> getNewTests() {
        return newTests;
    }
}
