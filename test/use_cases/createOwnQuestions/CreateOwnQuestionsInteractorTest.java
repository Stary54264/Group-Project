package use_cases.createOwnQuestions;

import data_access.FileTestDataAccessObject;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsPresenter;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CreateOwnQuestionsInteractorTest {

    FileTestDataAccessObject fileTestDataAccessObject = new FileTestDataAccessObject();
    CreateOwnQuestionsViewModel viewModel = new CreateOwnQuestionsViewModel();
    CreateOwnQuestionsPresenter presenter = new CreateOwnQuestionsPresenter(viewModel);
    CreateOwnQuestionsInteractor interactor = new CreateOwnQuestionsInteractor(presenter, fileTestDataAccessObject);
    CreateOwnQuestionsController controller = new CreateOwnQuestionsController(interactor);

    @Test
    public void testExecute() {
        List<String> questions = new ArrayList<String>();
        questions.add("a");
        questions.add("b");
        questions.add("c");
        List<String> questions1 = new ArrayList<>(questions);
        questions1.set(2, "");
        List<String> answers = new ArrayList<String>();
        answers.add("1");
        answers.add("2");
        answers.add("3");
        List<String> answers1 = new ArrayList<>(answers);
        answers1.set(1, "");
        List<ArrayList<String>> incorrect = new ArrayList<ArrayList<String>>();
        for (int i = 2; i < 5; i++) {
            ArrayList<String> curr = new ArrayList<String>();
            curr.add(String.valueOf(i));
            curr.add(String.valueOf(i + 1));
            curr.add(String.valueOf(i + 2));
            incorrect.add(curr);
        }
        controller.execute(questions, answers, incorrect, "test2", "none",
                "category 1");
        controller.execute(questions1, answers1, incorrect, "testEmpty", "none",
                "category 1");
        assert fileTestDataAccessObject.getTests().size() == 4;

    }
    @Test
    public void testEditExecute() {
        String question = "z";
        String answer = "4";
        ArrayList<String> incorrect = new ArrayList<String>();
        incorrect.add("3");
        incorrect.add("2");
        incorrect.add("1");
        controller.editExecute("test2", 1, question, answer, incorrect);
        assert Objects.equals(fileTestDataAccessObject.getTest("test2").getQuestions().get(0).getQuestion(), "z");
        assert Objects.equals(fileTestDataAccessObject.getTest("test2").getQuestions().get(0).getCorrectAnswer(), "4");
        controller.editExecute("test2", 1, "", answer, incorrect);
        assert Objects.equals(fileTestDataAccessObject.getTest("test2").getQuestions().get(0).getQuestion(), "z");

    }
}