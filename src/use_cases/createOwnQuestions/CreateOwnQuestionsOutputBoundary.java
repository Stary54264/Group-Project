package use_cases.createOwnQuestions;

public interface CreateOwnQuestionsOutputBoundary {
    void prepareSuccessView(CreateOwnQuestionsOutputData output);
    void prepareFailView();
    void prepareEditState(CreateOwnQuestionsOutputData output);
}
