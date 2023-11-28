package use_cases.getApiQuestions;
import app.Category;
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
        Category category = getApiQuestionsInputData.getQuestionCategory();
        QuestionType type = getApiQuestionsInputData.getQuestionType();
        QuestionDifficulty difficulty = getApiQuestionsInputData.getDifficulty();
        String testName = getApiQuestionsInputData.getTestName();

        ArrayList<Question> questions = null;
        try {
            questions = RetrieveQuestionsTrivia1(number, category.value, difficulty, type);
        } catch (Exception e) {
            apiPresenter.prepareFailView("Error occurred!"); // if throws exception, fail
        }
        String testName = "APITEST"+apiDataAccessObject.getTestCount();
        // create test with unique name & save & success view
        if (apiDataAccessObject.existsByName(testName)) {
            apiPresenter.prepareFailView("Name already exists!");
        } else {

            Test test = new TestBuilder().setName(testName).setQuestions(questions).setCategory(category.name).build();

            apiDataAccessObject.save(test);

            GetApiQuestionsOutputData getApiQuestionsOutputData = new GetApiQuestionsOutputData(true, testName);
            apiPresenter.prepareSuccessView(getApiQuestionsOutputData);
        }
    }
}

