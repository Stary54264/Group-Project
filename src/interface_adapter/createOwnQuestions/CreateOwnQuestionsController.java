package interface_adapter.createOwnQuestions;

import app.QuestionBuilder;
import use_cases.createOwnQuestions.CreateOwnQuestionsInputBoundary;
import use_cases.createOwnQuestions.CreateOwnQuestionsInputData;

import java.util.List;

public class CreateOwnQuestionsController {
    private final CreateOwnQuestionsInputBoundary createOwnQuestionsInteractor;

    public CreateOwnQuestionsController(CreateOwnQuestionsInputBoundary createOwnQuestionsInteractor) {
        this.createOwnQuestionsInteractor = createOwnQuestionsInteractor;
    }
    public void execute(String name, String comment, List<QuestionBuilder> questions) {
        CreateOwnQuestionsInputData createInput = new CreateOwnQuestionsInputData(name, comment, questions);
        createOwnQuestionsInteractor.execute(createInput);
    }
    public void editExecute(String testName) {
        createOwnQuestionsInteractor.editExecute(testName);

    }
}
