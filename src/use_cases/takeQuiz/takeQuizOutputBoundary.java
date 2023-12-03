package use_cases.takeQuiz;

public interface takeQuizOutputBoundary {
    void prepareNextQuestion(takeQuizOutputData data);
    void prepareResultView(takeQuizOutputData data);
}
