package use_cases.getApiQuestions;

import app.Category;
import app.QuestionDifficulty;
import app.QuestionType;
import data_access.APIDataAccessObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetApiQuestionsInteractorTest {
    @Test
    void successTest() {
        GetApiQuestionsInputData inputData = new GetApiQuestionsInputData(2, Category.AnyCategory,
                QuestionType.BOOL, QuestionDifficulty.EASY, "QUIZ #1");


    }
}