package use_cases.manageQuiz;

import entity.Test;

import java.util.List;

public interface manageQuizDataAccessInterface {
    List<Test> getTests();
    void refresh();
    void deleteTest(String name);
}
