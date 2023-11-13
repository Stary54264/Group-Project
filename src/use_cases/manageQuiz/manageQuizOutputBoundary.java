package use_cases.manageQuiz;

import entity.Test;

import java.util.List;

public interface manageQuizOutputBoundary {
    void prepareEditInterface(Test test);

    void refreshTests(List<Test> newTests);
}
