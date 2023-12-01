package view;

import app.Category;
import app.QuestionDifficulty;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import interface_adapter.getApiQuestions.GetApiQuestionsController;
import interface_adapter.getApiQuestions.GetApiQuestionsState;
import interface_adapter.getApiQuestions.GetApiQuestionsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class GetAPIQuestionsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "get api questions";
    private final GetApiQuestionsViewModel getApiQuestionsViewModel;
    private final JTextField nameInputField = new JTextField();
    private final JSpinner numberInputField = new JSpinner();
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

        LabelTextPanel testNameInfo = new LabelTextPanel(
                new JLabel(GetApiQuestionsViewModel.NAME_LABEL), nameInputField);
        LabelTextPanel numberInfo = new LabelTextPanel(
                new JLabel(GetApiQuestionsViewModel.NUMBER_LABEL), numberInputField);

        JPanel categoryPanel = new JPanel();
        String[] categoryOptions = {Category.AnyCategory.getName(), Category.General.getName(), Category.Books.getName(),
                Category.Film.getName(), Category.Music.getName(), Category.Musicals.getName(),
                Category.Television.getName(), Category.Video.getName(), Category.Board.getName(),
                Category.Nature.getName(), Category.Computers.getName(), Category.Mathematics.getName(),
                Category.Mythology.getName(), Category.Sports.getName(), Category.Sports.getName(),
                Category.Geography.getName(), Category.History.getName(), Category.Politics.getName(),
                Category.Art.getName(), Category.Celebrities.getName(), Category.Animals.getName(),
                Category.Vehicles.getName(), Category.Comics.getName(), Category.Gadgets.getName(),
                Category.Japanese.getName(), Category.Cartoon.getName()};
        for (String e: categoryOptions) {
            categoryBox.addItem(e);
        }
        categoryPanel.add(categoryBox);

        JPanel typePanel = new JPanel();
        String[] typeOptions = {"Any Type", "Multiple Choice", "True / False"};
        for (String e: typeOptions) {
            typeBox.addItem(e);
        }
        typePanel.add(typeBox);

        JPanel diffPanel = new JPanel();
        String[] diffOptions = {"Any Difficulty", "Easy", "Medium", "Hard"};
        for (String e: diffOptions) {
            diffBox.addItem(e);
        }
        diffPanel.add(diffBox);

        JPanel buttons = new JPanel();
        cancel = new JButton(GetApiQuestionsViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        takequiz = new JButton(GetApiQuestionsViewModel.QUIZ_LABEL);
        buttons.add(takequiz);

        cancel.addActionListener(this);
        takequiz.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(takequiz)) {
                            GetApiQuestionsState state = getApiQuestionsViewModel.getState();
                            getApiQuestionsController.execute(state.getNumber(), state.getCategory(), state.getType(),
                                    state.getDiff(), state.getTestName());
                            GetApiQuestionsState newState = getApiQuestionsViewModel.getState();
                            if (Objects.equals(newState.getTestNameError(), null)) {
                                JOptionPane.showMessageDialog(
                                        null, "Successfully created a test.");
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
                System.out.println(GetApiQuestionsViewModel.CATEGORY_LABEL + selectedOption);
            }
        });

        typeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the selection change
                String selectedOption = (String) typeBox.getSelectedItem();
                System.out.println(GetApiQuestionsViewModel.TYPE_LABEL + selectedOption);
            }
        });

        diffBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the selection change
                String selectedOption = (String) diffBox.getSelectedItem();
                System.out.println(GetApiQuestionsViewModel.DIFF_LABEL + selectedOption);
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
