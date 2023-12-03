package use_cases.takeQuiz;

import app.Main;
import data_access.FileTestDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.getResult.GetResultViewModel;

import interface_adapter.takeQuiz.takeQuizController;
import interface_adapter.takeQuiz.takeQuizPresenter;
import interface_adapter.takeQuiz.takeQuizViewModel;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class takeQuizInteractorTest {

    @Test
    void startTest() {
        newMain();

    }

    @Test
    void nextQuestion() {

    }

    void newMain() {
        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        GetResultViewModel getResultViewModel = new GetResultViewModel();
        takeQuizViewModel takeQuizViewModel = new takeQuizViewModel();

        FileTestDataAccessObject fileUserDataAccessObject = new FileTestDataAccessObject();

        takeQuizController takeQuizController = new takeQuizController(
                new takeQuizInteractor(
                        new takeQuizPresenter(takeQuizViewModel, getResultViewModel, viewManagerModel),
                        fileUserDataAccessObject
                )
        );

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        takeQuizController.start("Testing test");
        takeQuizController.answerQuestion("3");
        takeQuizController.answerQuestion("3");
        takeQuizController.answerQuestion("3");
        int correct = outContent.toString().split("YEP!", -1).length-1;
        assertEquals(correct, 1);
    }
}