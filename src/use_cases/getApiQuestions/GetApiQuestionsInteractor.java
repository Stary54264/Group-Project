package use_cases.getApiQuestions;
import app.TestBuilder;
import entity.Question;
import app.QuestionType;
import app.QuestionDifficulty;
import entity.Test;

import java.util.ArrayList;

import static data_access.APIDataAccessObject.RetrieveQuestionsTrivia1;

public class GetApiQuestionsInteractor implements GetApiQuestionsInputBoundary {
    final GetApiQuestionsDataAccessInterface apiDataAccessObject;
    final GetApiQuestionsOutputBoundary apiPresenter;

    public GetApiQuestionsInteractor(GetApiQuestionsDataAccessInterface getApiQuestionsDataAccessInterface,
                                     GetApiQuestionsOutputBoundary getApiQuestionsOutputBoundary) {
        this.apiDataAccessObject = getApiQuestionsDataAccessInterface;
        this.apiPresenter = getApiQuestionsOutputBoundary;
    }

    @Override
    public void execute(GetApiQuestionsInputData getApiQuestionsInputData) {
        int number = getApiQuestionsInputData.getNumberOfQuestions();
        int category = getApiQuestionsInputData.getQuestionCategory();
        QuestionType type = getApiQuestionsInputData.getQuestionType();
        QuestionDifficulty difficulty = getApiQuestionsInputData.getDifficulty();

        ArrayList<Question> questions = null;
        try {
            questions = RetrieveQuestionsTrivia1(number, category, difficulty, type);
        } catch (Exception e) {
            apiPresenter.prepareFailView("Error occurred!"); // if throws exception, fail
        }

        // create test with unique name & save & success view
        if (apiDataAccessObject.existsByName(testName)) {
            apiPresenter.prepareFailView("Name already exists!");
        } else {
            Test test = testFactory.create((ArrayList<Question>) questions, category.name, testName, "");
            apiDataAccessObject.save(test);

            GetApiQuestionsOutputData getApiQuestionsOutputData = new GetApiQuestionsOutputData(true, testName);
            apiPresenter.prepareSuccessView(getApiQuestionsOutputData);
        }
    }
}

