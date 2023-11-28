package use_cases.getDailyQuiz;

public interface GetDailyQuizOutputBoundary {
    void prepareSuccessView(GetDailyQuizOutputData response);

    void prepareFailView(String error);
}
