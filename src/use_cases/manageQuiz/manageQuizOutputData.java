package use_cases.manageQuiz;

import entity.Test;

import java.util.List;

public class manageQuizOutputData {
    private final List<Test> newTests;

    public manageQuizOutputData(List<Test> newTests) {
        this.newTests = newTests;
    }
}
