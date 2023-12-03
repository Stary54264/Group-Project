package use_cases.getDailyQuiz;

import entity.Test;

public interface GetDailyQuizDataAccessInterface {
    public Test getTest(String name);
    void save(Test test);

}
