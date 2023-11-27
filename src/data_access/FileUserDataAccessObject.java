package data_access;

import entity.Test;

import use_cases.getApiQuestions.GetApiQuestionsDataAccessInterface;
import use_cases.takeQuiz.takeQuizDataAccessInterface;
public class FileUserDataAccessObject implements takeQuizDataAccessInterface, GetApiQuestionsDataAccessInterface, use_cases.createOwnQuestions.CreateOwnQuestionsDataAccessInterface {

    @Override
    public Test getTest(String name) {
        // TODO fmwof
        return null;
    }

    @Override
    public void save(Test test) {
        // TODO fmwof
    }
}
