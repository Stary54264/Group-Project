package use_cases.manageQuiz;

import entity.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class manageQuizInteractor implements manageQuizInputBoundary {
    private final manageQuizOutputBoundary outputBoundary;
    private final manageQuizDataAccessInterface dataAccessInterface;

    public manageQuizInteractor(manageQuizOutputBoundary outputBoundary, manageQuizDataAccessInterface dataAccessInterface) {
        this.outputBoundary = outputBoundary;
        this.dataAccessInterface = dataAccessInterface;
    }

    @Override
    public void deleteTest(manageQuizInputdata data) {
        dataAccessInterface.deleteTest(data.test());
        outputBoundary.refreshTests(new manageQuizOutputData(getData()));
    }

    @Override
    public void refreshTests() {
        outputBoundary.refreshTests(new manageQuizOutputData(getData()));
    }

    private Map<String, String[]> getData() {

        List<Test> tests = dataAccessInterface.getTests();
        Map<String, String[]> out = new HashMap<>();
        for (Test test : tests) {
            if (test != null) out.put(test.getName(), new String[] {test.getComment(), test.getStats()});
        }
        return out;
    }
}
