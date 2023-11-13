package use_cases.takeQuiz;

public interface takeQuizInputBoundary {
    void startTest(String name);
    void nextQuestion(takeQuizInputData inputData);
}
