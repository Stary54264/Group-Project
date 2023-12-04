package use_cases.getResult;
import static org.junit.jupiter.api.Assertions.*;

import interface_adapter.getResult.GetResultController;
import interface_adapter.getResult.GetResultPresenter;
import interface_adapter.getResult.GetResultViewModel;
import interface_adapter.takeQuiz.takeQuizController;
import interface_adapter.takeQuiz.takeQuizPresenter;
import interface_adapter.takeQuiz.takeQuizViewModel;
import org.junit.jupiter.api.Test;
import data_access.*;
import interface_adapter.*;
import use_cases.takeQuiz.takeQuizInteractor;

class GetResultInteractorTest {
    @Test
    void executeTest() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        GetResultViewModel getResultViewModel = new GetResultViewModel();
        FileTestDataAccessObject getResultInputData = new FileTestDataAccessObject();
        GetResultOutputBoundary getResultOutputBoundary = new GetResultPresenter(viewManagerModel,getResultViewModel);
        GetResultInteractor getResultInteractor = new GetResultInteractor(getResultInputData,getResultOutputBoundary);
        takeQuizController takeQuizController = new takeQuizController(
                new takeQuizInteractor(
                        new takeQuizPresenter(new takeQuizViewModel(), new GetResultViewModel(), viewManagerModel),
                        getResultInputData
                )
        );
        takeQuizController.start("Testing test");
        takeQuizController.answerQuestion("3");
        takeQuizController.answerQuestion("3");
        takeQuizController.answerQuestion("3");

        GetResultController getResultController = new GetResultController(getResultInteractor);
        getResultController.execute("Testing test");
        assertEquals(getResultViewModel.result(),"Average: 33% (Correct: 1, Wrong: 2) Time taken: 00:00");


    }
}
