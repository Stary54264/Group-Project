package view;

import app.QuestionBuilder;
import interface_adapter.ViewManagerModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;

import javax.swing.*;

import interface_adapter.createOwnQuestions.CreateOwnQuestionsState;
import interface_adapter.manageQuiz.manageQuizViewModel;
import interface_adapter.takeQuiz.takeQuizController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Objects;


public class CreateOwnQuestionsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "Create Questions";
    private final CreateOwnQuestionsViewModel createOwnQuestionsViewModel;
    private final JTextField nameField = new JTextField(25);
    private final JTextField commentField = new JTextField(25);
    private final JTextField questionField = new JTextField(25);
    private final JTextField answerField = new JTextField(25);
    private final JTextField incorrect1Field = new JTextField(25);
    private final JTextField incorrect2Field = new JTextField(25);
    private final JTextField incorrect3Field = new JTextField(25);
    private final CreateOwnQuestionsController createOwnQuestionsController;
    private final JButton next, back;
    private final JLabel pageNumber;

    public CreateOwnQuestionsView(CreateOwnQuestionsController controller,
                                  CreateOwnQuestionsViewModel viewModel,
                                  ViewManagerModel viewManagerModel,
                                  manageQuizViewModel manageQuizViewModel,
                                  takeQuizController takeQuizController) {
        this.createOwnQuestionsController = controller;
        this.createOwnQuestionsViewModel = viewModel;
        createOwnQuestionsViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(CreateOwnQuestionsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel namePanel = new LabelTextPanel(
                new JLabel("Test Name"), nameField);
        LabelTextPanel commentPanel = new LabelTextPanel(
                new JLabel("Comment"), commentField);

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

        JPanel buttons = new JPanel();
        back = new JButton("Back");
        buttons.add(back);
        next = new JButton(CreateOwnQuestionsViewModel.NEXT_BUTTON_LABEL);
        buttons.add(next);
        JButton cancel = new JButton(CreateOwnQuestionsViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        JButton finished = new JButton(CreateOwnQuestionsViewModel.FINISHED_BUTTON_LABEL);
        buttons.add(finished);

        pageNumber = new JLabel("Page 1");
        buttons.add(pageNumber);

        next.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(next)) {
                            CreateOwnQuestionsState curr = createOwnQuestionsViewModel.getState();
                            curr.forward();
                            createOwnQuestionsViewModel.firePropertyChanged();
                        }
                    }
                }
        );
        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            CreateOwnQuestionsState curr = createOwnQuestionsViewModel.getState();
                            curr.back();
                            createOwnQuestionsViewModel.firePropertyChanged();
                        }
                    }
                }
        );
        cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewManagerModel.setActiveView(manageQuizViewModel.getViewName());
                        manageQuizViewModel.firePropertyChanged();
                        viewManagerModel.firePropertyChanged();
                    }
                }
        );
        finished.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CreateOwnQuestionsState currState = createOwnQuestionsViewModel.getState();
                        createOwnQuestionsController.execute(currState.getName(), currState.getComment(), currState.getBuilders());

                        CreateOwnQuestionsState newState = createOwnQuestionsViewModel.getState();
                        if (Objects.equals(newState.getError(), "")) {
                            JOptionPane.showMessageDialog(
                                    null, "Successfully created a test.");
                            takeQuizController.start(currState.getName());
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
                        currState.getBuilderOnPage().setQuestionText(text);
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
        nameField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateOwnQuestionsState currState = createOwnQuestionsViewModel.getState();
                        String text = nameField.getText() + e.getKeyChar();
                        currState.setName(text);
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
        commentField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateOwnQuestionsState currState = createOwnQuestionsViewModel.getState();
                        String text = commentField.getText() + e.getKeyChar();
                        currState.setComment(text);
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
                        currState.getBuilderOnPage().setCorrectAnswer(text);
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
        this.add(namePanel);
        this.add(commentPanel);
        this.add(questionPanel);
        this.add(answerPanel);
        this.add(incorrect1Panel);
        this.add(incorrect2Panel);
        this.add(incorrect3Panel);
        this.add(buttons);

        this.createOwnQuestionsViewModel.addPropertyChangeListener(this);
    }
    private void createIncorrectKeyListener(JTextField field, KeyEvent e, int pos) {
        CreateOwnQuestionsState currState = createOwnQuestionsViewModel.getState();
        ArrayList<String> currIncorrect = currState.getBuilderOnPage().getIncorrectAnswers();
        String text = field.getText() + e.getKeyChar();
        System.out.println(currIncorrect.size()+"siz");
        currIncorrect.set(pos, text);
        currState.getBuilderOnPage().setIncorrectAnswers(currIncorrect);
        createOwnQuestionsViewModel.setState(currState);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CreateOwnQuestionsState state = (CreateOwnQuestionsState) evt.getNewValue();
        QuestionBuilder builder = state.getBuilderOnPage();
        nameField.setText(state.getName());
        commentField.setText(state.getComment());
        questionField.setText(builder.getQuestionText());
        answerField.setText(builder.getCorrectAnswer());
        incorrect1Field.setText(builder.getIncorrectAnswers().get(0));
        try {
            incorrect2Field.setText(builder.getIncorrectAnswers().get(1));
            incorrect3Field.setText(builder.getIncorrectAnswers().get(2));
        } catch (Exception ignored) {
            incorrect2Field.setText("");
            incorrect3Field.setText("");
        }

        pageNumber.setText("Page "+(state.getPage()+1));
    }
}
