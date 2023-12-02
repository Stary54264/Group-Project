package use_cases.createOwnQuestions;

import entity.Test;

public interface CreateOwnQuestionsDataAccessInterface {
    void save(Test test);
    Test getTest(String name);
}
