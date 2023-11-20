package use_cases.createOwnQuestions;

import app.TestFactory;
import entity.Question;

import java.util.List;

public class CreateOwnQuestionsInteractor implements CreateOwnQuestionsInputBoundary {
    final CreateOwnQuestionsOutputBoundary questionsPresenter;
    final CreateOwnQuestionsDataAccessInterface questionsDataAccessInterface;
    final TestFactory testFactory;

    public CreateOwnQuestionsInteractor(CreateOwnQuestionsOutputBoundary questionsPresenter, CreateOwnQuestionsDataAccessInterface questionsDataAccessInterface, TestFactory testFactory) {
        this.questionsPresenter = questionsPresenter;
        this.questionsDataAccessInterface = questionsDataAccessInterface;
        this.testFactory = testFactory;
    }

    @Override
    public void execute(CreateOwnQuestionsInputData createOwnQuestionsInputData) {
        questionsDataAccessInterface.save(createOwnQuestionsInputData.getCreateTest());
        CreateOwnQuestionsOutputData outputData = new CreateOwnQuestionsOutputData(createOwnQuestionsInputData.getCreateTest());
        questionsPresenter.prepareSuccessView(outputData);

    }

}
