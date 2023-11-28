package data_access;

import entity.Test;

import use_cases.createOwnQuestions.CreateOwnQuestionsDataAccessInterface;
import use_cases.getApiQuestions.GetApiQuestionsDataAccessInterface;
import use_cases.takeQuiz.takeQuizDataAccessInterface;
import use_cases.uploadQuestions.UploadQuestionsDataAccessInterface;

public class FileTestDataAccessObject implements takeQuizDataAccessInterface,
        GetApiQuestionsDataAccessInterface,
        CreateOwnQuestionsDataAccessInterface,
        UploadQuestionsDataAccessInterface {

    @Override
    public Test getTest(String name) {
        // TODO fmwof
        return null;
    }

    @Override
    public Test readTest(String testName, String jsonPath) {
        // TODO stary
        return null;
    }

    @Override
    public void save(Test test) {
        // TODO fmwof
    }

    @Override
    public boolean existsByName(String name) {
        // TODO fmwof
    }
}
