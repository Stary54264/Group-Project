package data_access;

import entity.Question;
import entity.Test;

import entity.TestFactory;
import use_cases.getApiQuestions.GetApiQuestionsDataAccessInterface;
import use_cases.takeQuiz.takeQuizDataAccessInterface;
import use_cases.getResult.GetResultDataAccessInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileUserDataAccessObject implements takeQuizDataAccessInterface, GetApiQuestionsDataAccessInterface, GetResultDataAccessInterface{

    public FileUserDataAccessObject(String csvPath, TestFactory testFactory) throws IOException {
        private final Map<String, Test> tests = new HashMap<>();

        Test test = testFactory.create(questions, category, testName, comment);
        tests.put(testName, test);

    }
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
