package use_cases.createOwnQuestions;

public interface CreateOwnQuestionsInputBoundary {
    void execute(CreateOwnQuestionsInputData createOwnQuestionsInputData);

    void editExecute(String testName);
}
