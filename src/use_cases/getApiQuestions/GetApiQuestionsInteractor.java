package src.use_cases.getApiQuestions;
import src.entity.Question;
import src.use_cases.getApiQuestions.GetApiQuestionsInputData.QuestionType;
import src.use_cases.getApiQuestions.GetApiQuestionsInputData.QuestionDifficulty;

import java.io.IOException;
import java.util.List;

import static src.data_access.APIDataAccessObject.RetrieveQuestions;

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
        QuestionType questionType = getApiQuestionsInputData.getQuestionType();
        // convert questionType into int
        int type = 0;
        QuestionDifficulty questionDifficulty = getApiQuestionsInputData.getDifficulty();
        // convert questionDifficulty into int
        int difficulty = 0;

        try {
            List<Question> questions = RetrieveQuestions(number, category, difficulty, type);
        } catch (Exception e) {
            apiPresenter.prepareFailView("Error occurred!"); // if throws exception, fail
        }
        // create test with ID & save & success view
    }
}
