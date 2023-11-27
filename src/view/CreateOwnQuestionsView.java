package view;

import javax.swing.*;
import interface_adapter.ViewModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsState;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class CreateOwnQuestionsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "Create Questions";
    private final CreateOwnQuestionsViewModel createOwnQuestionsViewModel;
    private final JTextField questionField = new JTextField();
    private final JTextField answerField = new JTextField();
    private final JTextField incorrect1Field = new JTextField();
    private final JTextField incorrect2Field = new JTextField();
    private final JTextField incorrect3Field = new JTextField();
    private final CreateOwnQuestionsController createOwnQuestionsController;
    private final JButton next;
    private final JButton finished;
    private final JButton cancel;
    private List<String> questions = new ArrayList<String>();
    private List<String> answers = new ArrayList<String>();
    private List<ArrayList<String>> incorrectAnswers = new ArrayList<ArrayList<String>>();

    public CreateOwnQuestionsView(CreateOwnQuestionsController controller,
                                  CreateOwnQuestionsViewModel viewModel) {
        this.createOwnQuestionsController = controller;
        this.createOwnQuestionsViewModel = viewModel;
        createOwnQuestionsViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(CreateOwnQuestionsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel questionPanel = new LabelTextPanel(
                new JLabel(CreateOwnQuestionsViewModel.QUESTION_LABEL), questionField);
        LabelTextPanel answerPanel = new LabelTextPanel(
                new JLabel(CreateOwnQuestionsViewModel.ANSWER_LABEL), answerField);
        LabelTextPanel incorrect1Panel = new LabelTextPanel(
                new JLabel(CreateOwnQuestionsViewModel.INCORRECT_LABEL), incorrect1Field);
        LabelTextPanel incorrect2Panel = new LabelTextPanel(
                new JLabel(CreateOwnQuestionsViewModel.INCORRECT_LABEL), incorrect2Field);
        LabelTextPanel incorrect3Panel = new LabelTextPanel(
                new JLabel(CreateOwnQuestionsViewModel.INCORRECT_LABEL), incorrect3Field);
        ArrayList<JTextField> textFields = new ArrayList<JTextField>();
        textFields.add(questionField);
        textFields.add(answerField);
        textFields.add(incorrect1Field);
        textFields.add(incorrect2Field);
        textFields.add(incorrect3Field);

        JPanel buttons = new JPanel();
        next = new JButton(CreateOwnQuestionsViewModel.NEXT_BUTTON_LABEL);
        buttons.add(next);
        cancel = new JButton(CreateOwnQuestionsViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        finished = new JButton(CreateOwnQuestionsViewModel.FINISHED_BUTTON_LABEL);
        buttons.add(finished);

        next.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(next)) {
                            questions.add(questionField.getText());
                            answers.add(answerField.getText());
                            ArrayList<String> temp = new ArrayList<String>();
                            temp.add(incorrect1Field.getText());
                            temp.add(incorrect2Field.getText());
                            temp.add(incorrect3Field.getText());
                            incorrectAnswers.add(temp);
                            for (int i = 0; i < textFields.size(); i++) {
                                textFields.get(i).setText(null);
                            }

                        }
                    }
                }
        );
        cancel.addActionListener(this);
        finished.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CreateOwnQuestionsState currState = createOwnQuestionsViewModel.getState();
                        createOwnQuestionsController.execute(questions, answers, incorrectAnswers);
                        JOptionPane.showMessageDialog(null, "Successfully created a test!");
                    }
                }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
