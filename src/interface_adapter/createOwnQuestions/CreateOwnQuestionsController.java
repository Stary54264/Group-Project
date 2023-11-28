package interface_adapter.createOwnQuestions;

import use_cases.createOwnQuestions.CreateOwnQuestionsInputBoundary;
import use_cases.createOwnQuestions.CreateOwnQuestionsInputData;

import java.util.ArrayList;
import java.util.List;

public class CreateOwnQuestionsController {
    private final CreateOwnQuestionsInputBoundary createOwnQuestionsInteractor;

    public CreateOwnQuestionsController(CreateOwnQuestionsInputBoundary createOwnQuestionsInteractor) {
        this.createOwnQuestionsInteractor = createOwnQuestionsInteractor;
    }
    public void execute(List<String> questions, List<String> answers, List<ArrayList<String>> incorrectAnswers,
                        String name, String comment, String category) {
        CreateOwnQuestionsInputData createInput = new CreateOwnQuestionsInputData(questions, answers, incorrectAnswers,
                name, comment, category);
        createOwnQuestionsInteractor.execute(createInput);
    }
}
