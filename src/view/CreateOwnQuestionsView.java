package view;

import javax.swing.*;

public class CreateOwnQuestionsView {
    public final String viewname = "Create Questions";
    private final CreateOwnQuestionsViewModel createOwnQuestionsViewModel;
    private final JTextField questionField = new JTextField();
    private final JTextField answerField = new JTextField();
    private final JList<String> incorrectList = new JList<String>();
    private final CreateOwnQuestionsController createOwnQuestionsController;
    private final JButton createQuestions;
    private final JButton cancel;

    public CreateOwnQuestionsView(CreateOwnQuestionsController controller,
                                  CreateOwnQuestionsViewModel viewModel) {
        this.createOwnQuestionsController = controller;
        this.createOwnQuestionsViewModel = viewModel;
        createOwnQuestionsViewModel.add
    }
}
