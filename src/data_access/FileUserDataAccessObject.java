package src.data_access;

import src.entity.Test;

import src.use_cases.takeQuiz.takeQuizDataAccessInterface;
public class FileUserDataAccessObject implements takeQuizDataAccessInterface{

    @Override
    public Test getTest(String name) {
        return null;
    }
}
