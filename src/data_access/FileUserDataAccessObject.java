package data_access;

import app.Category;
import entity.CommonTestFactory;
import entity.Question;
import entity.Test;

import use_cases.getApiQuestions.GetApiQuestionsDataAccessInterface;
import use_cases.takeQuiz.takeQuizDataAccessInterface;
import use_cases.getResult.GetResultDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUserDataAccessObject implements takeQuizDataAccessInterface, GetApiQuestionsDataAccessInterface, GetResultDataAccessInterface{
    private final List<Test> tests = new ArrayList<>();
    private final String path;
    public FileUserDataAccessObject(String folderPath) throws IOException {
        ArrayList<Question> questions = new ArrayList<>();
        Category category = Category.AnyCategory;
        String testName = "name";
        String comment = "";

        Test test = new CommonTestFactory().setQuestions(questions).setCategory(category.name).setName(testName).setComment(comment).Build();

        path = folderPath;
        reloadTests();
    }
    private void reloadTests() {

    }

    @Override
    public Test getTest(String name) {
        return tests.stream().filter(t -> name.equals(t.getName())).findAny().orElse(null);
    }

    @Override
    public void save(Test test) {
        if (!tests.contains(test)) tests.add(test);

    }

    @Override
    public boolean existsByName(String testName) {
        return false; // implement later
    }
}
