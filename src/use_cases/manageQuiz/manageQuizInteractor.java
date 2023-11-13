package use_cases.manageQuiz;

import entity.Test;

import java.util.List;

public class manageQuizInteractor implements manageQuizInputBoundary {
    private final manageQuizOutputBoundary outputBoundary;
    private final manageQuizDataAccessInterface dataAccessInterface;

    public manageQuizInteractor(manageQuizOutputBoundary outputBoundary, manageQuizDataAccessInterface dataAccessInterface) {
        this.outputBoundary = outputBoundary;
        this.dataAccessInterface = dataAccessInterface;
    }

    @Override
    public void deleteTest(manageQuizInputdata data) {
        List<Test> tests = dataAccessInterface.getTests();
        outputBoundary.refreshTests(tests);
    }

    @Override
    public void editTest(manageQuizInputdata data) {

    }
}
