package data_access;

import entity.Test;

import use_cases.getApiQuestions.GetApiQuestionsDataAccessInterface;
import use_cases.takeQuiz.takeQuizDataAccessInterface;
public class FileUserDataAccessObject implements takeQuizDataAccessInterface, GetApiQuestionsDataAccessInterface, src.use_cases.createOwnQuestions.CreateOwnQuestionsDataAccessInterface {

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
