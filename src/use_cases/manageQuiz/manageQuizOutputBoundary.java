package use_cases.manageQuiz;

import entity.Test;

import java.util.List;

public interface manageQuizOutputBoundary {
    void prepareEditInterface(String name);

    void refreshTests(manageQuizOutputData data);
}
