package view;

import app.Category;
import app.QuestionDifficulty;
import interface_adapter.getApiQuestions.GetApiQuestionsController;
import interface_adapter.getApiQuestions.GetApiQuestionsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GetAPIQuestionsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "get api questions";
    private final GetApiQuestionsViewModel getApiQuestionsViewModel;
    private final JTextField nameInputField = new JTextField();
    private final JInternalFrame numberInputField = new JInternalFrame();
    private final JComboBox<String> categoryBox = new JComboBox<>();
    private final JComboBox<String> typeBox = new JComboBox<>();
    private final JComboBox<String> diffBox = new JComboBox<>();
    private final GetApiQuestionsController getApiQuestionsController;
    private final JButton cancel;
    private final JButton takequiz;

    public GetAPIQuestionsView(GetApiQuestionsController controller,
                               GetApiQuestionsViewModel viewModel) {
        this.getApiQuestionsController = controller;
        this.getApiQuestionsViewModel = viewModel;
        getApiQuestionsViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(GetApiQuestionsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.cancel = new JButton("Cancel");
        this.takequiz = new JButton("Take Quiz");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
