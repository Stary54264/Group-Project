package data_access;

import entity.Test;

import use_cases.createOwnQuestions.CreateOwnQuestionsDataAccessInterface;
import use_cases.getApiQuestions.GetApiQuestionsDataAccessInterface;
import use_cases.getDailyQuiz.GetDailyQuizDataAccessInterface;
import use_cases.getResult.GetResultDataAccessInterface;
import use_cases.manageQuiz.manageQuizDataAccessInterface;
import use_cases.takeQuiz.takeQuizDataAccessInterface;
import use_cases.uploadQuestions.UploadQuestionsDataAccessInterface;
import use_cases.EditQuestions.EditQuestionsDataAccessInterface;

import java.util.List;

public class FileTestDataAccessObject implements
        takeQuizDataAccessInterface,
        manageQuizDataAccessInterface,
        GetApiQuestionsDataAccessInterface,
        GetDailyQuizDataAccessInterface,
        CreateOwnQuestionsDataAccessInterface,
        UploadQuestionsDataAccessInterface,
        GetResultDataAccessInterface,
        EditQuestionsDataAccessInterface {

    public int getTestCount() {
        // TODO fmwof
        return 0;
    }

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
        return false;
    }

    @Override
    public List<Test> getTests() {
        return null;
    }

    @Override
    public void deleteTest(String name) {

    }
}
