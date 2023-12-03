package interface_adapter.manageQuiz;

import use_cases.manageQuiz.manageQuizInputBoundary;
import use_cases.manageQuiz.manageQuizInputdata;

public class manageQuizController {
    private final manageQuizInputBoundary interactor;

    public manageQuizController(manageQuizInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void refreshTests() {
        interactor.refreshTests();
    }

    public void deleteTest(String name) {
        interactor.deleteTest(new manageQuizInputdata(name));
    }
}
