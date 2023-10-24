package use_cases.get_api_questions;

public interface GetApiQuestionsDataAccessInterface {
    String RetrieveQuestions(int numberOfQuestions, int questionCategory, GetApiQuestionsInputData.QuestionType questionType, GetApiQuestionsInputData.QuestionDifficulty difficulty);
}
