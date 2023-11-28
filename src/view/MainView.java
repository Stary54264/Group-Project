package view;

import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import interface_adapter.uploadQuestions.UploadQuestionsController;
import interface_adapter.uploadQuestions.UploadQuestionsState;
import interface_adapter.uploadQuestions.UploadQuestionsViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class MainView implements ActionListener, PropertyChangeListener {
    public final String viewname = "Main Menu";
    private final CreateOwnQuestionsViewModel createOwnQuestionsViewModel;
    private final CreateOwnQuestionsController createOwnQuestionsController;
    private final UploadQuestionsController uploadQuestionsController;
    private final UploadQuestionsViewModel uploadQuestionsViewModel;
    private final JTextField testNameInputField = new JTextField();
    private final JTextField jsonPathInputField = new JTextField();
    private final ArrayList<TestPanel> tests;
    private final JButton createQuestions, apiQuestions, uploadQuestions, createTest;

    public MainView(UploadQuestionsController uploadQuestionsController,
                    UploadQuestionsViewModel uploadQuestionsViewModel) {
        this.uploadQuestionsController = uploadQuestionsController;
        this.uploadQuestionsViewModel = uploadQuestionsViewModel;
        LabelTextPanel testNameInfo = new LabelTextPanel(
                new JLabel(UploadQuestionsViewModel.TEST_NAME_LABEL), testNameInputField);
        LabelTextPanel jsonPathInfo = new LabelTextPanel(
                new JLabel(UploadQuestionsViewModel.JSON_PATH_LABEL), jsonPathInputField);
        JPanel buttons = new JPanel();
        uploadQuestions = new JButton(UploadQuestionsViewModel.UPLOAD_BUTTON_LABEL);
        buttons.add(uploadQuestions);
        uploadQuestions.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(uploadQuestions)) {
                            UploadQuestionsState currentState = uploadQuestionsViewModel.getState();
                            uploadQuestionsController.execute(
                                    currentState.getTestName(),
                                    currentState.getJsonPath());
                        }
                    }
                });
    }

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
