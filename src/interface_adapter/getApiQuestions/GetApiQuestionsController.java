package interface_adapter.getApiQuestions;

import use_cases.getApiQuestions.GetApiQuestionsInputBoundary;
import use_cases.getApiQuestions.GetApiQuestionsInputData;
import use_cases.getApiQuestions.GetApiQuestionsInputData.QuestionType;
import use_cases.getApiQuestions.GetApiQuestionsInputData.QuestionDifficulty;

public class GetApiQuestionsController {
    final GetApiQuestionsInputBoundary getApiQuestionsInteractor;
    public GetApiQuestionsController(GetApiQuestionsInputBoundary getApiQuestionsInteractor) {
        this.getApiQuestionsInteractor = getApiQuestionsInteractor;
    }

    public void execute(int numberOfQuestions, int questionCategory,
                        QuestionType questionType, QuestionDifficulty difficulty) {
        GetApiQuestionsInputData getApiQuestionsInputData = new GetApiQuestionsInputData(
                numberOfQuestions, questionCategory, questionType, difficulty);

        getApiQuestionsInteractor.execute(getApiQuestionsInputData);
    }
}
