package use_cases.takeQuiz;

import src.entity.Test;

public interface takeQuizDataAccessInterface {
    Test getTest(String name);
}
