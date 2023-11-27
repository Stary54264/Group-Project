package use_cases.uploadQuestions;

import entity.Test;

import java.io.IOException;

public interface UploadQuestionsUserDataAccessInterface {
    Test getTest(String testName);
    void save(Test test);
    boolean existByName(String testName);
}
