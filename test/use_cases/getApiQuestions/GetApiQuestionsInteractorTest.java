package use_cases.getApiQuestions;

import app.Category;
import app.QuestionDifficulty;
import app.QuestionType;
import data_access.FileTestDataAccessObject;
import interface_adapter.getApiQuestions.GetApiQuestionsController;
import interface_adapter.getApiQuestions.GetApiQuestionsPresenter;
import interface_adapter.getApiQuestions.GetApiQuestionsState;
import interface_adapter.getApiQuestions.GetApiQuestionsViewModel;
import interface_adapter.takeQuiz.takeQuizViewModel;
import interface_adapter.uploadQuestions.UploadQuestionsController;
import interface_adapter.uploadQuestions.UploadQuestionsPresenter;
import interface_adapter.uploadQuestions.UploadQuestionsState;
import interface_adapter.uploadQuestions.UploadQuestionsViewModel;
import org.junit.jupiter.api.Test;
import use_cases.uploadQuestions.UploadQuestionsDataAccessInterface;
import use_cases.uploadQuestions.UploadQuestionsInputBoundary;
import use_cases.uploadQuestions.UploadQuestionsInteractor;
import use_cases.uploadQuestions.UploadQuestionsOutputBoundary;

import static org.junit.jupiter.api.Assertions.*;

class GetApiQuestionsInteractorTest {

    @Test
    void executeSuccessTest() {
        FileTestDataAccessObject dataAccessInterface = new FileTestDataAccessObject();
        GetApiQuestionsPresenter getApiQuestionsPresenter = new GetApiQuestionsPresenter(
                new GetApiQuestionsViewModel(), new takeQuizViewModel()
        );
        GetApiQuestionsInputData getApiQuestionsInputData = new GetApiQuestionsInputData(
                10,
                Category.AnyCategory,
                QuestionType.ALL,
                QuestionDifficulty.ALL,
                "Api testing test");
        GetApiQuestionsInputBoundary getApiQuestionsInteractor = new GetApiQuestionsInteractor(dataAccessInterface,
                getApiQuestionsPresenter);
        getApiQuestionsInteractor.execute(getApiQuestionsInputData);
        dataAccessInterface.deleteTest("Api testing test");
    }

    @Test
    void executeFailTest() {
        FileTestDataAccessObject dataAccessInterface = new FileTestDataAccessObject();
        GetApiQuestionsOutputBoundary getApiQuestionsPresenter =new GetApiQuestionsOutputBoundary() {
            @Override
            public void prepareSuccessView(GetApiQuestionsOutputData getApiQuestionsOutputData) {
                fail("Use case successful is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Failed!", error);
            }
        };
        GetApiQuestionsInputData getApiQuestionsInputData = new GetApiQuestionsInputData(
                10,
                Category.AnyCategory,
                QuestionType.ALL,
                QuestionDifficulty.ALL,
                "Api testing test");
        GetApiQuestionsInputBoundary getApiQuestionsInteractor = new GetApiQuestionsInteractor(dataAccessInterface,
                getApiQuestionsPresenter);
        getApiQuestionsInteractor.execute(getApiQuestionsInputData);
        dataAccessInterface.deleteTest("Api testing test");
    }
}