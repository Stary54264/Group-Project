package interface_adapter.getDailyQuiz;

import app.Category;
import app.QuestionDifficulty;
import app.QuestionType;
import use_cases.getApiQuestions.GetApiQuestionsInputBoundary;
import use_cases.getApiQuestions.GetApiQuestionsInputData;

public class GetDailyQuizController {
    final GetApiQuestionsInputBoundary getApiQuestionsInteractor;
    public GetDailyQuizController(GetApiQuestionsInputBoundary getApiQuestionsInteractor) {
        this.getApiQuestionsInteractor = getApiQuestionsInteractor;
    }

    public void execute(int numberOfQuestions, Category questionCategory,
                        QuestionType questionType, QuestionDifficulty difficulty, String testName) {
        GetApiQuestionsInputData getApiQuestionsInputData = new GetApiQuestionsInputData(
                numberOfQuestions, questionCategory, questionType, difficulty, testName);

        getApiQuestionsInteractor.execute(getApiQuestionsInputData);
    }
}
