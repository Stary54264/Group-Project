package use_cases.getApiQuestions;
import app.*;
import entity.Question;
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
        Category category = getApiQuestionsInputData.getQuestionCategory();
        QuestionType type = getApiQuestionsInputData.getQuestionType();
        QuestionDifficulty difficulty = getApiQuestionsInputData.getDifficulty();
        //String testName = getApiQuestionsInputData.getTestName();

        String questions = "";
        try {
            questions = RetrieveQuestionsTrivia1(number, category, difficulty, type);
        } catch (Exception e) {
            apiPresenter.prepareFailView("Error occurred!"); // if throws exception, fail
        }
        String testName = "APITEST"+apiDataAccessObject.getTestCount();
        // create test with unique name & save & success view
        if (apiDataAccessObject.existsByName(testName)) {
            apiPresenter.prepareFailView("Name already exists!");
        } else {

            Test test = Serializer.DecodeTest(questions, testName);

            apiDataAccessObject.save(test);

            GetApiQuestionsOutputData getApiQuestionsOutputData = new GetApiQuestionsOutputData(true, testName);
            apiPresenter.prepareSuccessView(getApiQuestionsOutputData);
        }
    }
}

