package src.interface_adapter.createOwnQuestions;

import entity.Question;
import use_cases.createOwnQuestions.CreateOwnQuestionsInputBoundary;
import use_cases.createOwnQuestions.CreateOwnQuestionsInputData;

import java.util.List;

public class CreateOwnQuestionsController {
    private final CreateOwnQuestionsInputBoundary createOwnQuestionsInteractor;

    public CreateOwnQuestionsController(CreateOwnQuestionsInputBoundary createOwnQuestionsInteractor) {
        this.createOwnQuestionsInteractor = createOwnQuestionsInteractor;
    }
    public void execute(List<String> questions, List<Integer> ids, List<String> answers, List<String[]> incorrectAnswers) {
        CreateOwnQuestionsInputData createInput = new CreateOwnQuestionsInputData(questions, ids, answers, incorrectAnswers);
        createOwnQuestionsInteractor.execute(createInput);
    }
}
