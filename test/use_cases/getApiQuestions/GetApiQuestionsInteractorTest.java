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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GetApiQuestionsInteractorTest {

    @Test
    void executeSuccessTest() throws InterruptedException {
        Thread.sleep(5000);
        FileTestDataAccessObject dataAccessInterface = new FileTestDataAccessObject();
        GetApiQuestionsViewModel getApiQuestionsViewModel = new GetApiQuestionsViewModel();
        takeQuizViewModel takeQuizViewModel = new takeQuizViewModel();
        GetApiQuestionsPresenter getApiQuestionsPresenter = new GetApiQuestionsPresenter(
                getApiQuestionsViewModel, takeQuizViewModel);
        GetApiQuestionsInputBoundary getApiQuestionsInteractor = new GetApiQuestionsInteractor(dataAccessInterface,
                getApiQuestionsPresenter);
        GetApiQuestionsController getApiQuestionsController = new GetApiQuestionsController(getApiQuestionsInteractor);
        getApiQuestionsController.execute(10,
                Category.AnyCategory,
                QuestionType.ALL,
                QuestionDifficulty.ALL,
                "Api testing test");
        GetApiQuestionsState getApiQuestionsState = new GetApiQuestionsState();
        getApiQuestionsViewModel.setState(getApiQuestionsState);
        getApiQuestionsState.getTestNameError();
        getApiQuestionsState.getNumber();
        getApiQuestionsState.getCategory();
        getApiQuestionsState.getType();
        getApiQuestionsState.getDiff();
        getApiQuestionsState.setTestName("Api testing test");
        getApiQuestionsState.setNumber(10);
        getApiQuestionsState.setCategory(Category.AnyCategory);
        getApiQuestionsState.setType(QuestionType.ALL);
        getApiQuestionsState.setDiff(QuestionDifficulty.ALL);
        assertEquals("Api testing test", getApiQuestionsState.getTestName());
        dataAccessInterface.deleteTest("Api testing test");
    }

    @Test
    void executeFailTest() {
        FileTestDataAccessObject dataAccessInterface = new FileTestDataAccessObject();
        GetApiQuestionsViewModel getApiQuestionsViewModel = new GetApiQuestionsViewModel();
        takeQuizViewModel takeQuizViewModel = new takeQuizViewModel();
        GetApiQuestionsPresenter getApiQuestionsPresenter = new GetApiQuestionsPresenter(
                getApiQuestionsViewModel, takeQuizViewModel);
        GetApiQuestionsInputBoundary getApiQuestionsInteractor = new GetApiQuestionsInteractor(dataAccessInterface,
                getApiQuestionsPresenter);
        GetApiQuestionsController getApiQuestionsController = new GetApiQuestionsController(getApiQuestionsInteractor);
        getApiQuestionsController.execute(0,
                Category.AnyCategory,
                QuestionType.ALL,
                QuestionDifficulty.ALL,
                "Api testing test");
        dataAccessInterface.deleteTest("Api testing test");
    }
}