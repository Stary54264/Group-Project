package use_cases.uploadQuestions;

public interface UploadQuestionsOutputBoundary {
    void prepareView(boolean nameError, boolean fileError);
}
