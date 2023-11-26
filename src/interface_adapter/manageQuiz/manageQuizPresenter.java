package interface_adapter.manageQuiz;

import entity.Test;
import use_cases.manageQuiz.manageQuizOutputBoundary;

import java.util.List;

public class manageQuizPresenter implements manageQuizOutputBoundary {
    @Override
    public void prepareEditInterface(Test test) {

    }

    @Override
    public void refreshTests(List<Test> newTests) {

    }
}
