package use_cases.takeQuiz;

public interface takeQuizInputBoundary {
    void startTest(takeQuizInputData inputData);
    void nextQuestion(takeQuizInputData inputData);
}
