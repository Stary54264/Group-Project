package interface_adapter.takeQuiz;

import use_cases.takeQuiz.takeQuizInputBoundary;
import use_cases.takeQuiz.takeQuizInputData;

public class takeQuizController {

    private final takeQuizInputBoundary interactor;
    public takeQuizController(takeQuizInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void start(String name) {
        interactor.startTest(name);
    }

    public void answerQuestion(String answer) {
        takeQuizInputData data = new takeQuizInputData(answer);
        interactor.nextQuestion(data);
    }
}
