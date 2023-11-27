package view;

import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import interface_adapter.uploadQuestions.UploadQuestionsController;
import interface_adapter.uploadQuestions.UploadQuestionsViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class MainView implements ActionListener, PropertyChangeListener {
    public final String viewname = "Main Menu";
    private final CreateOwnQuestionsViewModel createOwnQuestionsViewModel;
    private final CreateOwnQuestionsController createOwnQuestionsController;
    private final UploadQuestionsController uploadQuestionsController;
    private final ArrayList<TestPanel> tests;
    private final JButton createQuestions, apiQuestions, uploadQuestions, createTest;

    public MainView(UploadQuestionsController uploadQuestionsController) {
        this.uploadQuestionsController = uploadQuestionsController;
        JPanel buttons = new JPanel();
        uploadQuestions = new JButton(UploadQuestionsViewModel.UPLOAD_BUTTON_LABEL);
        buttons.add(uploadQuestions);

    }

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
