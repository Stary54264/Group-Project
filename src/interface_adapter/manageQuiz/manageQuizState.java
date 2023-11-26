package interface_adapter.manageQuiz;

import use_cases.manageQuiz.manageQuizOutputData;

public class manageQuizState {
    private final manageQuizOutputData outputData;

    public manageQuizState(manageQuizOutputData outputData) {
        this.outputData = outputData;
    }
}
