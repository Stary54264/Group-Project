package src.interface_adapter.createOwnQuestions;

import src.use_cases.createOwnQuestions.CreateOwnQuestionsOutputData;

public class CreateOwnQuestionsState {
    private CreateOwnQuestionsOutputData questionsOutputData;
    public CreateOwnQuestionsState(CreateOwnQuestionsOutputData output) {
        this.questionsOutputData = output;
    }
}
