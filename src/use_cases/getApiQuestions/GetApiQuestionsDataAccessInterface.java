package use_cases.getApiQuestions;

import entity.Test;

public interface GetApiQuestionsDataAccessInterface {
    //api access is static
    void save(Test test);

    boolean existsByID(int testID);
}
