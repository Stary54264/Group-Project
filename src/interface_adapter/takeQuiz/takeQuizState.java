package interface_adapter.takeQuiz;

import use_cases.takeQuiz.takeQuizOutputData;

public class takeQuizState {
    private final takeQuizOutputData outputData;

    public takeQuizState(takeQuizOutputData outputData) {
        this.outputData = outputData;
    }
}
