package use_cases.getDailyQuiz;

import entity.Test;

public interface GetDailyQuizDataAccessInterface {
    Test getTest(String name);
    void save(Test test);

}
