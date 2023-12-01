package interface_adapter.EditQuestions;

import use_cases.EditQuestions.EditQuestionsInputBoundary;
import use_cases.EditQuestions.EditQuestionsInputData;

import java.util.ArrayList;
import java.util.List;

public class EditQuestionsController {
    private final EditQuestionsInputBoundary editQuestionsInteractor;

    public EditQuestionsController(EditQuestionsInputBoundary editQuestionsInteractor) {
        this.editQuestionsInteractor = editQuestionsInteractor;
    }
    public void execute(String testName, int questionNum, String question,
                        String answer, ArrayList<String> incorrectAnswers) {
        EditQuestionsInputData editQuestionsInputData = new EditQuestionsInputData(
                testName, questionNum, question, answer, incorrectAnswers);
        editQuestionsInteractor.execute(editQuestionsInputData);

    }
}
