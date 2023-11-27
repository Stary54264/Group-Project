package use_cases.uploadQuestions;

public interface UploadQuestionsOutputBoundary {
    void prepareSuccessView(String message);
    void prepareFailView(String message);
}
