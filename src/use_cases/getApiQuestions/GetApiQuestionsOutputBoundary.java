package use_cases.getApiQuestions;

public interface GetApiQuestionsOutputBoundary {
    void prepareSuccessView(GetApiQuestionsOutputData response);

    void prepareFailView(String error);
}
