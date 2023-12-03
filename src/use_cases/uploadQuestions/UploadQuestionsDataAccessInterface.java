package use_cases.uploadQuestions;

import entity.Test;

public interface UploadQuestionsDataAccessInterface {
    Test readTest(String testName, String txtPath);
    void save(Test test);
    boolean existsByName(String testName);
}
