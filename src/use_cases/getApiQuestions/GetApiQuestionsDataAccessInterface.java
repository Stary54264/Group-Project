package src.use_cases.getApiQuestions;

import src.entity.Test;

public interface GetApiQuestionsDataAccessInterface {
    //api access is static
    void save(Test test);

    boolean existsByID(int testID);
}
