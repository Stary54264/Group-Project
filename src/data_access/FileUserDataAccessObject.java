package data_access;

import entity.Test;

import use_cases.createOwnQuestions.CreateOwnQuestionsDataAccessInterface;
import use_cases.getApiQuestions.GetApiQuestionsDataAccessInterface;
import use_cases.takeQuiz.takeQuizDataAccessInterface;
import use_cases.uploadQuestions.UploadQuestionsUserDataAccessInterface;

public class FileUserDataAccessObject implements takeQuizDataAccessInterface,
        GetApiQuestionsDataAccessInterface,
        CreateOwnQuestionsDataAccessInterface,
        UploadQuestionsUserDataAccessInterface {

    @Override
    public Test getTest(String name) {
        // TODO fmwof
        return null;
    }

    @Override
    public Test readTest(String testName, String csvPath) {

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
