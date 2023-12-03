package use_cases.uploadQuestions;

import data_access.FileTestDataAccessObject;
import interface_adapter.uploadQuestions.UploadQuestionsController;
import interface_adapter.uploadQuestions.UploadQuestionsPresenter;
import interface_adapter.uploadQuestions.UploadQuestionsState;
import interface_adapter.uploadQuestions.UploadQuestionsViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UploadQuestionsInteractorTest {

    @Test
    void executeSuccessTest() {
        UploadQuestionsDataAccessInterface dataAccessInterface = new FileTestDataAccessObject();
        UploadQuestionsViewModel uploadQuestionsViewModel = new UploadQuestionsViewModel();
        UploadQuestionsState uploadQuestionsState = new UploadQuestionsState();
        uploadQuestionsViewModel.setState(uploadQuestionsState);
        UploadQuestionsOutputBoundary uploadQuestionsPresenter = new UploadQuestionsPresenter(uploadQuestionsViewModel);
        UploadQuestionsInputBoundary uploadQuestionsInteractor = new UploadQuestionsInteractor(dataAccessInterface,
                uploadQuestionsPresenter);
        UploadQuestionsController uploadQuestionsController = new UploadQuestionsController(uploadQuestionsInteractor);
        uploadQuestionsController.execute("AnotherTestingTest", "Quizzes/TestingTest.txt");
        String message = uploadQuestionsState.getMessage();
        UploadQuestionsState anotherUploadQuestionsState = new UploadQuestionsState(uploadQuestionsState);
        anotherUploadQuestionsState.getTestName();
        anotherUploadQuestionsState.getTxtPath();
        anotherUploadQuestionsState.setTestName("AnotherTestingTest");
        anotherUploadQuestionsState.setTxtPath("Quizzes/TestingTest.txt");
        assertEquals("Uploaded successfully!", message);
    }

    @Test
    void executeFailTest1() {
        UploadQuestionsDataAccessInterface dataAccessInterface = new FileTestDataAccessObject();
        UploadQuestionsViewModel uploadQuestionsViewModel = new UploadQuestionsViewModel();
        UploadQuestionsState uploadQuestionsState = new UploadQuestionsState();
        uploadQuestionsViewModel.setState(uploadQuestionsState);
        UploadQuestionsOutputBoundary uploadQuestionsPresenter = new UploadQuestionsPresenter(uploadQuestionsViewModel);
        UploadQuestionsInputBoundary uploadQuestionsInteractor = new UploadQuestionsInteractor(
                dataAccessInterface, uploadQuestionsPresenter);
        UploadQuestionsController uploadQuestionsController = new UploadQuestionsController(uploadQuestionsInteractor);
        uploadQuestionsController.execute("AnotherTestingTest", "Quizzes/InvalidPath.txt");
        String message = uploadQuestionsState.getMessage();
        assertEquals("Failed to upload. File does not exist!", message);
    }

    @Test
    void executeFailTest2() {
        UploadQuestionsDataAccessInterface dataAccessInterface = new FileTestDataAccessObject();
        UploadQuestionsViewModel uploadQuestionsViewModel = new UploadQuestionsViewModel();
        UploadQuestionsState uploadQuestionsState = new UploadQuestionsState();
        uploadQuestionsViewModel.setState(uploadQuestionsState);
        UploadQuestionsOutputBoundary uploadQuestionsPresenter = new UploadQuestionsPresenter(uploadQuestionsViewModel);
        UploadQuestionsInputBoundary uploadQuestionsInteractor = new UploadQuestionsInteractor(
                dataAccessInterface, uploadQuestionsPresenter);
        UploadQuestionsController uploadQuestionsController = new UploadQuestionsController(uploadQuestionsInteractor);
        uploadQuestionsController.execute("TestingTest", "Quizzes/TestingTest.txt");
        String message = uploadQuestionsState.getMessage();
        assertEquals("Failed to upload. Test name exists!", message);
    }
}