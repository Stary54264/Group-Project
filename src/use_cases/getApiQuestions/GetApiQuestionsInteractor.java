package use_cases.getApiQuestions;
import app.Category;
import entity.CommonTestFactory;
import entity.Question;
import app.QuestionType;
import app.QuestionDifficulty;
import entity.Test;

import java.util.ArrayList;
import java.util.List;

import static data_access.APIDataAccessObject.RetrieveQuestions;

public class GetApiQuestionsInteractor implements GetApiQuestionsInputBoundary {
    final GetApiQuestionsDataAccessInterface apiDataAccessObject;
    final GetApiQuestionsOutputBoundary apiPresenter;
    final CommonTestFactory testFactory;

    public GetApiQuestionsInteractor(GetApiQuestionsDataAccessInterface getApiQuestionsDataAccessInterface,
                                     GetApiQuestionsOutputBoundary getApiQuestionsOutputBoundary,
                                     CommonTestFactory testFactory) {
        this.apiDataAccessObject = getApiQuestionsDataAccessInterface;
        this.apiPresenter = getApiQuestionsOutputBoundary;
        this.testFactory = testFactory;
    }

    @Override
    public void execute(GetApiQuestionsInputData getApiQuestionsInputData) {
        int number = getApiQuestionsInputData.getNumberOfQuestions();
        Category category = getApiQuestionsInputData.getQuestionCategory();
        QuestionType type = getApiQuestionsInputData.getQuestionType();
        QuestionDifficulty difficulty = getApiQuestionsInputData.getDifficulty();
        String testName = getApiQuestionsInputData.getTestName();

        List<Question> questions = null;
        try {
            questions = RetrieveQuestions(number, category, difficulty, type);
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
