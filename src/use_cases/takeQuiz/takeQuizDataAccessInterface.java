package use_cases.takeQuiz;

import entity.Test;

public interface takeQuizDataAccessInterface {
    Test getTest(String name);
}
