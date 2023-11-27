package interface_adapter.createOwnQuestions;

import entity.Question;
import interface_adapter.ViewModel;
import use_cases.createOwnQuestions.CreateOwnQuestionsOutputData;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsState;

import java.beans.PropertyChangeListener;
import java.util.List;

public class CreateOwnQuestionsViewModel extends ViewModel {
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public static final String TITLE_LABEL = "Create Questions";
    public static final String FINISHED_BUTTON_LABEL = "Finish";
    public static final String NEXT_BUTTON_LABEL = "Next";
    public static final String QUESTION_LABEL = "Question: ";
    public static final String ANSWER_LABEL = "Answer: ";
    public static final String INCORRECT_LABEL = "Incorrect answer: ";
    private CreateOwnQuestionsOutputData output;
    private CreateOwnQuestionsState questionsState = new CreateOwnQuestionsState();

    public CreateOwnQuestionsViewModel() {
        super("questions");
    }

    public void setState(CreateOwnQuestionsState questionsState) {
        this.questionsState = questionsState;
    }

    public CreateOwnQuestionsState getState() {
        return this.questionsState;
    }
    @Override
    public void firePropertyChanged() {

    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}