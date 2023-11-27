package entity;

import app.Category;

import java.util.ArrayList;

public interface TestFactory {
    Test create(ArrayList<Question> questions, String category, String testName);
}
