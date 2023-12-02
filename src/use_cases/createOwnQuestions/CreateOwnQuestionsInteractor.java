package use_cases.createOwnQuestions;

import app.TestBuilder;
import entity.Question;
import entity.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateOwnQuestionsInteractor implements CreateOwnQuestionsInputBoundary {
    final CreateOwnQuestionsOutputBoundary questionsPresenter;
    final CreateOwnQuestionsDataAccessInterface questionsDataAccessInterface;

    public CreateOwnQuestionsInteractor(CreateOwnQuestionsOutputBoundary questionsPresenter,
                                        CreateOwnQuestionsDataAccessInterface questionsDataAccessInterface) {
        this.questionsPresenter = questionsPresenter;
        this.questionsDataAccessInterface = questionsDataAccessInterface;
    }

    @Override
    public void execute(CreateOwnQuestionsInputData createOwnQuestionsInputData) {
        if (!createOwnQuestionsInputData.getCreateTest().getQuestions().contains(null)) {
            questionsDataAccessInterface.save(createOwnQuestionsInputData.getCreateTest());
        }
        CreateOwnQuestionsOutputData outputData = new CreateOwnQuestionsOutputData(createOwnQuestionsInputData.getCreateTest());
        if (outputData.getQuestionList().contains(null)) {
            questionsPresenter.prepareFailView();
        }
        else {
            questionsPresenter.prepareSuccessView(outputData);
        }
    }
    public void editExecute(CreateOwnQuestionsInputData createOwnQuestionsInputData) {
        Test test = questionsDataAccessInterface.getTest(createOwnQuestionsInputData.getTestName());
        questionsDataAccessInterface.deleteTest(test.getName());
        Question newQuestion = createOwnQuestionsInputData.getQuestion();
        int num = createOwnQuestionsInputData.getQuestionNum();
        ArrayList<Question> currQuestions = test.getQuestions();
        for (int i = 0; i < currQuestions.size(); i++) {
            if (i + 1 == num) {
                currQuestions.set(i, newQuestion);
            }
        }
        test.setQuestions(currQuestions);
        questionsDataAccessInterface.save(test);
    }

}
