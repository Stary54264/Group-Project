package view;

import app.Category;
import app.QuestionDifficulty;
import app.QuestionType;
import interface_adapter.ViewManagerModel;
import interface_adapter.getApiQuestions.GetApiQuestionsController;
import interface_adapter.getApiQuestions.GetApiQuestionsState;
import interface_adapter.getApiQuestions.GetApiQuestionsViewModel;
import interface_adapter.manageQuiz.manageQuizViewModel;
import interface_adapter.takeQuiz.takeQuizController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.Objects;

public class GetAPIQuestionsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "get api questions";
    private final GetApiQuestionsViewModel getApiQuestionsViewModel;
    private final JTextField nameInputField = new JTextField(15);
    private final JSpinner numberInputField = new JSpinner(new SpinnerNumberModel(10, 1, 100, 1));
    private final JComboBox<String> categoryBox = new JComboBox<>();
    private final JComboBox<String> typeBox = new JComboBox<>();
    private final JComboBox<String> diffBox = new JComboBox<>();
    private final GetApiQuestionsController getApiQuestionsController;
    private final JButton cancel;
    private final JButton takequiz;

    public GetAPIQuestionsView(ViewManagerModel viewManagerModel,
                               manageQuizViewModel manageQuizViewModel,
                               takeQuizController takeQuizController,
                               GetApiQuestionsController controller,
                               GetApiQuestionsViewModel viewModel) {
        this.getApiQuestionsController = controller;
        this.getApiQuestionsViewModel = viewModel;
        getApiQuestionsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GetApiQuestionsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel testNameInfo = new LabelTextPanel(
                new JLabel(GetApiQuestionsViewModel.NAME_LABEL), nameInputField);
        LabelTextPanel numberInfo = new LabelTextPanel(
                new JLabel(GetApiQuestionsViewModel.NUMBER_LABEL), numberInputField);

        JPanel categoryPanel = new JPanel();
        String[] categoryOptions = Arrays.stream(Category.values()).map(v -> v.name).toArray(String[]::new);

        for (String e: categoryOptions) {
            categoryBox.addItem(e);
        }
        categoryPanel.add(new JLabel(GetApiQuestionsViewModel.CATEGORY_LABEL));
        categoryPanel.add(categoryBox);

        JPanel typePanel = new JPanel();

        String[] typeOptions = Arrays.stream(QuestionType.values()).map(v -> v.name).toArray(String[]::new);
        for (String e: typeOptions) {
            typeBox.addItem(e);
        }
        typePanel.add(new JLabel(GetApiQuestionsViewModel.TYPE_LABEL));
        typePanel.add(typeBox);

        JPanel diffPanel = new JPanel();
        String[] diffOptions = Arrays.stream(QuestionDifficulty.values()).map(v -> v.name).toArray(String[]::new);
        for (String e: diffOptions) {
            diffBox.addItem(e);
        }
        diffPanel.add(new JLabel(GetApiQuestionsViewModel.DIFF_LABEL));
        diffPanel.add(diffBox);

        JPanel buttons = new JPanel();
        cancel = new JButton(GetApiQuestionsViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        takequiz = new JButton(GetApiQuestionsViewModel.QUIZ_LABEL);
        buttons.add(takequiz);

        cancel.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(cancel)) {
                    viewManagerModel.setActiveView(manageQuizViewModel.getViewName());
                    manageQuizViewModel.firePropertyChanged();
                    viewManagerModel.firePropertyChanged();
                }
            }
        });

        takequiz.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(takequiz)) {
                            GetApiQuestionsState state = getApiQuestionsViewModel.getState();
                            getApiQuestionsController.execute((int)numberInputField.getValue(), state.getCategory(), state.getType(),
                                    state.getDiff(), state.getTestName());
                            System.out.println(state.getTestName());
                            System.out.println(state.getDiff());
                            System.out.println(state.getCategory());
                            GetApiQuestionsState newState = getApiQuestionsViewModel.getState();
                            if (Objects.equals(newState.getTestNameError(), null)) {
                                JOptionPane.showMessageDialog(
                                        null, "Successfully created a test.");
                                takeQuizController.start(newState.getTestName());
                            }
                            else {
                                JOptionPane.showMessageDialog(null, newState.getTestNameError());
                            }
                        }
                    }
                });

        nameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        GetApiQuestionsState currentState = getApiQuestionsViewModel.getState();
                        String text = nameInputField.getText() + e.getKeyChar();
                        currentState.setTestName(text);
                        getApiQuestionsViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                }
        );

        numberInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                        char typedChar = e.getKeyChar();
                        System.out.println(typedChar);
                        if (Character.isDigit(typedChar)) {
                            GetApiQuestionsState currentState = getApiQuestionsViewModel.getState();
                            int currentNumber = Integer.parseInt(String.valueOf(numberInputField.getValue()));
                            currentState.setNumber(currentNumber * 10 + Character.getNumericValue(typedChar));
                            getApiQuestionsViewModel.setState(currentState);
                        }
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        categoryBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the selection change
                String selectedOption = (String) categoryBox.getSelectedItem();

                GetApiQuestionsState currentState = getApiQuestionsViewModel.getState();
                currentState.setCategory(Category.getByName(selectedOption));
            }
        });

        typeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the selection change
                String selectedOption = (String) typeBox.getSelectedItem();

                GetApiQuestionsState currentState = getApiQuestionsViewModel.getState();
                currentState.setType(QuestionType.getByName(selectedOption));
            }
        });

        diffBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the selection change
                String selectedOption = (String) diffBox.getSelectedItem();
                //System.out.println(GetApiQuestionsViewModel.DIFF_LABEL + selectedOption);
                GetApiQuestionsState currentState = getApiQuestionsViewModel.getState();
                currentState.setDiff(QuestionDifficulty.getByName(selectedOption));
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(testNameInfo);
        this.add(numberInfo);
        this.add(categoryPanel);
        this.add(typePanel);
        this.add(diffPanel);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        GetApiQuestionsState state = (GetApiQuestionsState) evt.getNewValue();
        if (state.getTestNameError() != null) {
            JOptionPane.showMessageDialog(this, state.getTestNameError());
        }
    }
}
