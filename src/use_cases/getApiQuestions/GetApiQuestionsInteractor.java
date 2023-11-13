package use_cases.getApiQuestions;
import entity.Question;
import app.QuestionType;
import app.QuestionDifficulty;
import entity.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static data_access.APIDataAccessObject.RetrieveQuestions;

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

        List<Question> questions = null;
        try {
            questions = RetrieveQuestions(number, category, difficulty, type);
        } catch (Exception e) {
            apiPresenter.prepareFailView("Error occurred!"); // if throws exception, fail
        }

        // create test with name & save & success view
        Test test = new Test((ArrayList<Question>) questions);
    }
}
