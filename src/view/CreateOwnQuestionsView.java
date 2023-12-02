package view;

import entity.Question;
import interface_adapter.ViewManagerModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;

import javax.swing.*;
import interface_adapter.ViewModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsState;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.manageQuiz.manageQuizViewModel;

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
import java.util.Objects;


public class CreateOwnQuestionsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "Create Questions";
    private final CreateOwnQuestionsViewModel createOwnQuestionsViewModel;
    private final ViewManagerModel viewManagerModel;
    private final manageQuizViewModel manageQuizViewModel;
    private final JTextField questionField = new JTextField(15);
    private final JTextField answerField = new JTextField(15);
    private final JTextField incorrect1Field = new JTextField(15);
    private final JTextField incorrect2Field = new JTextField(15);
    private final JTextField incorrect3Field = new JTextField(15);
    private final CreateOwnQuestionsController createOwnQuestionsController;
    private final JButton next;
    private final JButton finished;
    private final JButton cancel;
    private List<String> questions = new ArrayList<String>();
    private List<String> answers = new ArrayList<String>();
    private List<ArrayList<String>> incorrectAnswers = new ArrayList<ArrayList<String>>();

    public CreateOwnQuestionsView(CreateOwnQuestionsController controller,
                                  CreateOwnQuestionsViewModel viewModel,
                                  ViewManagerModel viewManagerModel,
                                  manageQuizViewModel manageQuizViewModel) {
        this.createOwnQuestionsController = controller;
        this.createOwnQuestionsViewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
        this.manageQuizViewModel = manageQuizViewModel;
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
                            CreateOwnQuestionsState curr = createOwnQuestionsViewModel.getState();
                            curr.addQuestions(curr.getQuestion());
                            curr.addAnswers(curr.getAnswer());
                            curr.addIncorrectAnswers(curr.getIncorrect());
                            for (int i = 0; i < textFields.size(); i++) {
                                textFields.get(i).setText(null);
                            }

                        }
                    }
                }
        );
        cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewManagerModel.setActiveView(manageQuizViewModel.getViewName());
                        viewManagerModel.firePropertyChanged();
                    }
                }
        );
        finished.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        next.doClick();
                        for (int i = 0; i < textFields.size(); i++) {
                            textFields.get(i).setText(null);
                        }
                        String name = JOptionPane.showInputDialog("Enter the name for your test: ");
                        String comment = JOptionPane.showInputDialog("Enter a comment for your test: ");
                        String category = JOptionPane.showInputDialog("Enter a category for your test: ");
                        CreateOwnQuestionsState currState = createOwnQuestionsViewModel.getState();
                        createOwnQuestionsController.execute(
                                currState.getQuestions(), currState.getAnswers(), currState.getIncorrectAnswers(),
                                name, comment, category);
                        CreateOwnQuestionsState newState = createOwnQuestionsViewModel.getState();
                        if (Objects.equals(newState.getError(), "")) {
                            JOptionPane.showMessageDialog(
                                    null, "Successfully created a test.");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, newState.getError());
                        }
                        newState.clearAll();
                        createOwnQuestionsViewModel.setState(newState);

                    }
                }
        );
        questionField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateOwnQuestionsState currState = createOwnQuestionsViewModel.getState();
                        String text = questionField.getText() + e.getKeyChar();
                        currState.setQuestion(text);
                        createOwnQuestionsViewModel.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
        answerField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateOwnQuestionsState currState = createOwnQuestionsViewModel.getState();
                        String text = answerField.getText() + e.getKeyChar();
                        currState.setAnswer(text);
                        createOwnQuestionsViewModel.setState(currState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
        incorrect1Field.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        createIncorrectKeyListener(incorrect1Field, e, 0);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
        incorrect2Field.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        createIncorrectKeyListener(incorrect2Field, e, 1);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
        incorrect3Field.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        createIncorrectKeyListener(incorrect3Field, e, 2);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(questionPanel);
        this.add(answerPanel);
        this.add(incorrect1Panel);
        this.add(incorrect2Panel);
        this.add(incorrect3Panel);
        this.add(buttons);
    }
    private void createIncorrectKeyListener(JTextField field, KeyEvent e, int pos) {
        CreateOwnQuestionsState currState = createOwnQuestionsViewModel.getState();
        ArrayList<String> currIncorrect = currState.getIncorrect();
        String text = field.getText() + e.getKeyChar();
        currIncorrect.set(pos, text);
        currState.setIncorrect(currIncorrect);
        createOwnQuestionsViewModel.setState(currState);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
