package use_cases.EditQuestions;
import entity.Question;
import entity.Test;
import use_cases.editQuestions.EditQuestionsOutputBoundary;
import use_cases.EditQuestions.EditQuestionsDataAccessInterface;

import java.util.ArrayList;

public class EditQuestionsInteractor implements EditQuestionsInputBoundary {
    private EditQuestionsOutputBoundary editQuestionsPresenter;
    private EditQuestionsDataAccessInterface editQuestionsDataAccessInterface;
    public EditQuestionsInteractor(EditQuestionsOutputBoundary editQuestionsPresenter,
                        EditQuestionsDataAccessInterface editQuestionsDataAccessInterface) {
        this.editQuestionsPresenter = editQuestionsPresenter;
        this.editQuestionsDataAccessInterface = editQuestionsDataAccessInterface;
    }

    @Override
    public void execute(EditQuestionsInputData editQuestionsInputData) {
        Test test = editQuestionsDataAccessInterface.getTest(editQuestionsInputData.getTestName());
        Question newQuestion = editQuestionsInputData.getQuestion();
        int num = editQuestionsInputData.getQuestionNum();
        ArrayList<Question> currQuestions = test.getQuestions();
        for (int i = 0; i < currQuestions.size(); i++) {
            if (i + 1 == num) {
                currQuestions.set(i, newQuestion);
            }
        }
        test.setQuestions(currQuestions);
    }
}
