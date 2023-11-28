package view;

import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import interface_adapter.takeQuiz.takeQuizState;
import interface_adapter.uploadQuestions.UploadQuestionsController;
import interface_adapter.uploadQuestions.UploadQuestionsState;
import interface_adapter.uploadQuestions.UploadQuestionsViewModel;
import interface_adapter.manageQuiz.manageQuizViewModel;
import interface_adapter.manageQuiz.manageQuizController;
import interface_adapter.takeQuiz.takeQuizViewModel;
import interface_adapter.takeQuiz.takeQuizController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Map;

public class MainView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "Main Menu";
    private final CreateOwnQuestionsController createOwnQuestionsController;
    private final CreateOwnQuestionsViewModel createOwnQuestionsViewModel;
    private final UploadQuestionsController uploadQuestionsController;
    private final UploadQuestionsViewModel uploadQuestionsViewModel;
    private final manageQuizController manageQuizController;
    private final manageQuizViewModel manageQuizViewModel;
    private final takeQuizController takeQuizController;
    private final takeQuizViewModel takeQuizViewModel;
    private final JTextField testNameInputField = new JTextField();
    private final JTextField jsonPathInputField = new JTextField();
    private ArrayList<TestPanel> tests;
    private final JButton createQuestions, apiQuestions, uploadQuestions, getDailyQuiz, refreshTests;

    public MainView(CreateOwnQuestionsViewModel createOwnQuestionsViewModel, CreateOwnQuestionsController createOwnQuestionsController, UploadQuestionsController uploadQuestionsController,
                    UploadQuestionsViewModel uploadQuestionsViewModel, manageQuizController manageQuizController, manageQuizViewModel manageQuizViewModel, interface_adapter.takeQuiz.takeQuizController takeQuizController, interface_adapter.takeQuiz.takeQuizViewModel takeQuizViewModel) {
        this.createOwnQuestionsViewModel = createOwnQuestionsViewModel;
        this.createOwnQuestionsController = createOwnQuestionsController;
        this.uploadQuestionsController = uploadQuestionsController;
        this.uploadQuestionsViewModel = uploadQuestionsViewModel;
        this.manageQuizController = manageQuizController;
        this.manageQuizViewModel = manageQuizViewModel;
        this.takeQuizController = takeQuizController;
        this.takeQuizViewModel = takeQuizViewModel;

        LabelTextPanel testNameInfo = new LabelTextPanel(new JLabel(UploadQuestionsViewModel.TEST_NAME_LABEL), testNameInputField);
        LabelTextPanel jsonPathInfo = new LabelTextPanel(new JLabel(UploadQuestionsViewModel.JSON_PATH_LABEL), jsonPathInputField);

        JPanel buttons = new JPanel();
        createQuestions = new JButton("Create Own Questions");
        buttons.add(createQuestions);
        apiQuestions = new JButton("API Questions");
        buttons.add(apiQuestions);
        uploadQuestions = new JButton(UploadQuestionsViewModel.UPLOAD_BUTTON_LABEL);
        buttons.add(uploadQuestions);
        getDailyQuiz = new JButton("DAILY QUIZ");
        buttons.add(getDailyQuiz);
        refreshTests = new JButton("REFRESH");
        buttons.add(refreshTests);

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
        testNameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        UploadQuestionsState currentState = uploadQuestionsViewModel.getState();
                        String text = testNameInputField.getText() + e.getKeyChar();
                        currentState.setTestName(text);
                        uploadQuestionsViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                }
                );
        jsonPathInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        UploadQuestionsState currentState = uploadQuestionsViewModel.getState();
                        String text = jsonPathInputField.getText() + e.getKeyChar();
                        currentState.setJsonPath(text);
                        uploadQuestionsViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                }
                );

        tests = new ArrayList<>();
        this.add(testNameInfo);
        this.add(jsonPathInfo);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    private void updateTests(Map<String, String> newTests) {
        for (TestPanel t: tests) {
            this.remove(t);
        }
        for (String s: newTests.values()) {
            this.add(new TestPanel(s, newTests.get(s)));
        }
    }

    private class TestPanel extends JPanel {
        TestPanel(String name, String comment) {
            this.add(new JLabel(name));
            this.add(new JLabel(comment));
            JButton edit = new JButton("edit");
            JButton play = new JButton("play");
            JButton delete = new JButton("delete");
            this.add(edit);
            this.add(play);
            this.add(delete);

            edit.addActionListener(
                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(edit)) {
                                //createOwnQuestionsController.execute();
                            }
                        }
                    }
            );
            play.addActionListener(
                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(play)) {
                                takeQuizState currentState = takeQuizViewModel.getState();
                                takeQuizController.start(name);
                            }
                        }
                    }
            );
            delete.addActionListener(
                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(delete)) {
                                manageQuizController.deleteTest(name);
                                updateTests(manageQuizViewModel.getState().getTests());
                            }
                        }
                    }
            );
        }
    }
}
