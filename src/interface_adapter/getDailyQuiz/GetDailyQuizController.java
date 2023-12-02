package interface_adapter.getDailyQuiz;

import use_cases.getDailyQuiz.GetDailyQuizInputBoundary;

public class GetDailyQuizController {
    final GetDailyQuizInputBoundary interactor;
    public GetDailyQuizController(GetDailyQuizInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute() {
        interactor.execute();
    }
}
