package use_cases.getDailyQuiz;

import entity.Test;

public interface GetDailyQuizDataAccessInterface {
    //api access is static
    void save(Test test);

}
