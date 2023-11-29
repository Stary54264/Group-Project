package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import interface_adapter.getApiQuestions.GetApiQuestionsController;
import interface_adapter.getApiQuestions.GetApiQuestionsViewModel;

public class GetAPIQuestionsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "get API questions";
    public final GetApiQuestionsController controller;
    public final GetApiQuestionsViewModel viewModel;

    public GetAPIQuestionsView(GetApiQuestionsController controller, GetApiQuestionsViewModel viewModel) {
        this.viewModel = viewModel;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
