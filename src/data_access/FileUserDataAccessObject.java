package data_access;

import entity.Test;

import use_cases.getApiQuestions.GetApiQuestionsDataAccessInterface;
import use_cases.takeQuiz.takeQuizDataAccessInterface;
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
    public boolean existsByName(String testName) {
        return false; // implement later
    }
}
