package use_cases.createOwnQuestions;

import entity.Question;

import java.util.List;

public class CreateOwnQuestionsInteractor implements CreateOwnQuestionsInputBoundary{
    final CreateOwnQuestionsOutputBoundary questionsPresenter;
    final CreateOwnQuestionsDataAccessInterface questionsDataAccessInterface;

    public CreateOwnQuestionsInteractor(CreateOwnQuestionsOutputBoundary questionsPresenter, CreateOwnQuestionsDataAccessInterface questionsDataAccessInterface) {
        this.questionsPresenter = questionsPresenter;
        this.questionsDataAccessInterface = questionsDataAccessInterface;
    }

    @Override
    public void execute(CreateOwnQuestionsInputData createOwnQuestionsInputData) {
        List<Question> questionList = createOwnQuestionsInputData.getQuestions();
        CreateOwnQuestionsOutputData outputData = new CreateOwnQuestionsOutputData(questionList);
        questionsDataAccessInterface.save(questionList);
        questionsPresenter.prepareSuccessView(outputData);

    }

}
