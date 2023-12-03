package use_cases.uploadQuestions;

import data_access.FileTestDataAccessObject;
import interface_adapter.uploadQuestions.UploadQuestionsPresenter;
import interface_adapter.uploadQuestions.UploadQuestionsState;
import interface_adapter.uploadQuestions.UploadQuestionsViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UploadQuestionsInteractorTest {

    @Test
    void executeTest() {
        UploadQuestionsDataAccessInterface dataAccessInterface = new FileTestDataAccessObject();
        UploadQuestionsViewModel uploadQuestionsViewModel = new UploadQuestionsViewModel();
        UploadQuestionsState uploadQuestionsState = new UploadQuestionsState();
        uploadQuestionsViewModel.setState(uploadQuestionsState);
        UploadQuestionsOutputBoundary uploadQuestionsPresenter = new UploadQuestionsPresenter(uploadQuestionsViewModel);
        UploadQuestionsInputData uploadQuestionsInputData = new UploadQuestionsInputData(
                "AnotherEmptyTest", "Quizzes/EmptyTest.txt");
        UploadQuestionsInputBoundary uploadQuestionsInteractor = new UploadQuestionsInteractor(
                dataAccessInterface, uploadQuestionsPresenter);
        uploadQuestionsInteractor.execute(uploadQuestionsInputData);
        String message = uploadQuestionsState.getMessage();
        assertEquals("Uploaded successfully!", message);
    }
}