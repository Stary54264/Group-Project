package src.data_access;

import src.entity.Test;

import src.use_cases.getApiQuestions.GetApiQuestionsDataAccessInterface;
import src.use_cases.takeQuiz.takeQuizDataAccessInterface;
public class FileUserDataAccessObject implements takeQuizDataAccessInterface, GetApiQuestionsDataAccessInterface {

    @Override
    public Test getTest(String name) {
        return null;
    }

    @Override
    public void save(Test test) {
        // implement later
    }

    @Override
    public boolean existsByID(int testID) {
        return false; // implement later
    }
}
