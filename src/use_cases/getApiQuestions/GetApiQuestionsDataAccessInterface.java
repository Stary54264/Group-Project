package use_cases.getApiQuestions;

public interface GetApiQuestionsDataAccessInterface {
    String RetrieveQuestions(int numberOfQuestions, int questionCategory, GetApiQuestionsInputData.QuestionType questionType, GetApiQuestionsInputData.QuestionDifficulty difficulty);
}
