package use_cases.createOwnQuestions;

import app.QuestionBuilder;
import entity.Question;
import entity.Test;

import java.util.ArrayList;

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
        if (createOwnQuestionsInputData.getCreateTest() != null) {
            questionsDataAccessInterface.save(createOwnQuestionsInputData.getCreateTest());
            if (questionsDataAccessInterface.getTest(createOwnQuestionsInputData.getCreateTest().getName()) != null) {
                CreateOwnQuestionsOutputData outputData = new CreateOwnQuestionsOutputData(createOwnQuestionsInputData.getCreateTest());
                questionsPresenter.prepareSuccessView(outputData);
            } else {
                questionsPresenter.prepareFailView();
            }
        } else {
            questionsPresenter.prepareFailView();
        }
    }
    public void editExecute(String testName) {
        Test test = questionsDataAccessInterface.getTest(testName);
        ArrayList<QuestionBuilder> out = new ArrayList<>();
        for (Question q: test.getQuestions()) {
            out.add(new QuestionBuilder()
                    .setQuestionText(q.getQuestion())
                    .setIncorrectAnswers(q.getIncorrectAnswers())
                    .setCorrectAnswer(q.getCorrectAnswer()));
        }

        CreateOwnQuestionsOutputData outputData = new CreateOwnQuestionsOutputData(test.getName(), test.getComment(), out);
        questionsPresenter.prepareEditState(outputData);
    }

}
