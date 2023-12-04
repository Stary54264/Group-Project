package use_cases.createOwnQuestions;

import app.TextQuestionBuilder;
import data_access.FileTestDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsPresenter;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsState;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CreateOwnQuestionsInteractorTest {

    ViewManagerModel viewManagerModel = new ViewManagerModel();
    FileTestDataAccessObject fileTestDataAccessObject = new FileTestDataAccessObject();
    CreateOwnQuestionsViewModel viewModel = new CreateOwnQuestionsViewModel();
    CreateOwnQuestionsPresenter presenter = new CreateOwnQuestionsPresenter(viewManagerModel, viewModel);
    CreateOwnQuestionsInteractor interactor = new CreateOwnQuestionsInteractor(presenter, fileTestDataAccessObject);
    CreateOwnQuestionsController controller = new CreateOwnQuestionsController(interactor);

    @Test
    public void testExecute() {
        int sizeBefore = fileTestDataAccessObject.getTests().size();
        TextQuestionBuilder questionBuilder = new TextQuestionBuilder();
        TextQuestionBuilder questionBuilder2 = new TextQuestionBuilder();
        questionBuilder.setQuestionText("a");
        questionBuilder.setCorrectAnswer("1");
        questionBuilder2.setQuestionText("");
        questionBuilder2.setCorrectAnswer("");
        ArrayList<String> curr = new ArrayList<String>();
        curr.add(String.valueOf(2));
        curr.add(String.valueOf(3));
        curr.add(String.valueOf(4));
        questionBuilder.setIncorrectAnswers(curr);
        questionBuilder2.setIncorrectAnswers(curr);
        List<TextQuestionBuilder> questions = new ArrayList<TextQuestionBuilder>();
        questions.add(questionBuilder);
        questions.add(questionBuilder2);
        List<TextQuestionBuilder> questions2 = new ArrayList<TextQuestionBuilder>();
        questions2.add(questionBuilder);
        controller.execute("test1", "none", questions);
        int sizeAfter = fileTestDataAccessObject.getTests().size();
        assert sizeBefore == sizeAfter;
        controller.execute("test1", "none", questions2);
        assert sizeBefore + 1 == fileTestDataAccessObject.getTests().size();
        CreateOwnQuestionsState createOwnQuestionsState = new CreateOwnQuestionsState();
        createOwnQuestionsState.getBuilders();
        createOwnQuestionsState.getBuilderOnPage();
        createOwnQuestionsState.forward();
        createOwnQuestionsState.back();
        createOwnQuestionsState.getPage();
        createOwnQuestionsState.getComment();
        createOwnQuestionsState.getName();
        createOwnQuestionsState.setName(null);
        createOwnQuestionsState.setComment(null);
        createOwnQuestionsState.getError();
        createOwnQuestionsState.clearAll();
    }
    @Test
    public void testEditExecute() {
        int sizeBefore = fileTestDataAccessObject.getTests().size();
        controller.editExecute("test1");
        interactor.editExecute("test1");
        int sizeAfter = fileTestDataAccessObject.getTests().size();
        assert sizeBefore == sizeAfter;
        fileTestDataAccessObject.deleteTest("test1");

    }

}