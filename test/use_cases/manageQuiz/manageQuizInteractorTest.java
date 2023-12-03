package use_cases.manageQuiz;

import data_access.FileTestDataAccessObject;
import interface_adapter.manageQuiz.manageQuizController;
import interface_adapter.manageQuiz.manageQuizPresenter;
import interface_adapter.manageQuiz.manageQuizViewModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class manageQuizInteractorTest {

    @Test
    void deleteTest() {
        FileTestDataAccessObject fileUserDataAccessObject = new FileTestDataAccessObject();
        manageQuizViewModel manageQuizViewModel = new manageQuizViewModel();
        manageQuizController manageQuizController = new manageQuizController(
                new manageQuizInteractor(
                        new manageQuizPresenter(manageQuizViewModel),
                        fileUserDataAccessObject
                )
        );
        fileUserDataAccessObject.save(new entity.Test("test", "None", new ArrayList<>(), new ArrayList<>()));
        manageQuizController.deleteTest("test");
        manageQuizController.refreshTests();
        assertEquals(fileUserDataAccessObject.getTest("test"), null);
    }

    @Test
    void editTest() {
    }
}