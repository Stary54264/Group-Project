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
        dataAccessInterface.deleteTest(data.getTest());
        outputBoundary.refreshTests(new manageQuizOutputData(getNames()));
    }

    @Override
    public void refreshTests() {
        List<Test> tests = dataAccessInterface.getTests();
        outputBoundary.refreshTests(new manageQuizOutputData(getNames()));
    }

    private Map<String, String> getNames() {
        List<Test> tests = dataAccessInterface.getTests();
        Map<String, String> out = new HashMap<String, String>();
        for (Test test : tests) {
            out.put(test.getName(), test.getComment());
        }
        return out;
    }
}
