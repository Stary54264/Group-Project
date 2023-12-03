package use_cases.createOwnQuestions;

import app.QuestionBuilder;
import app.TestBuilder;
import data_access.FileTestDataAccessObject;
import entity.Question;
import interface_adapter.ViewManagerModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsPresenter;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import org.junit.jupiter.api.Test;
import view.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

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
        QuestionBuilder questionBuilder = new QuestionBuilder();
        QuestionBuilder questionBuilder2 = new QuestionBuilder();
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
        List<QuestionBuilder> questions = new ArrayList<QuestionBuilder>();
        questions.add(questionBuilder);
        questions.add(questionBuilder2);
        List<QuestionBuilder> questions2 = new ArrayList<QuestionBuilder>();
        questions2.add(questionBuilder);

        controller.execute("test1", "none", questions);
        int sizeAfter = fileTestDataAccessObject.getTests().size();
        assert sizeBefore == sizeAfter;
        controller.execute("test1", "none", questions2);
        assert sizeBefore + 1 == fileTestDataAccessObject.getTests().size();


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