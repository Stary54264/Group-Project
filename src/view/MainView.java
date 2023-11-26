package view;

import interface_adapter.manageQuiz.manageQuizController;
import interface_adapter.manageQuiz.manageQuizViewModel;

import javax.swing.*;

public class MainView {
    public final String viewname = "Main Menu";
    private final manageQuizController manageController;
    private final manageQuizViewModel manageView;

    private final JTextField questionField = new JTextField();
    private final JTextField answerField = new JTextField();
    private final JList<String> incorrectList = new JList<String>();
    private final JButton createQuestions;
    private final JButton cancel;

    public MainView(manageQuizController manageController, manageQuizViewModel manageView) {
        this.manageController = manageController;
        this.manageView = manageView;
    }
}
