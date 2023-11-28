package use_cases.createOwnQuestions;

import app.TestBuilder;
import entity.Question;

import java.util.List;

public class CreateOwnQuestionsInteractor implements CreateOwnQuestionsInputBoundary {
    final CreateOwnQuestionsOutputBoundary questionsPresenter;
    final CreateOwnQuestionsDataAccessInterface questionsDataAccessInterface;

    public CreateOwnQuestionsInteractor(CreateOwnQuestionsOutputBoundary questionsPresenter, CreateOwnQuestionsDataAccessInterface questionsDataAccessInterface) {
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

}
