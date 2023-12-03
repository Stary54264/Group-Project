package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.getApiQuestions.GetApiQuestionsViewModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import interface_adapter.manageQuiz.manageQuizState;
import interface_adapter.uploadQuestions.UploadQuestionsController;
import interface_adapter.uploadQuestions.UploadQuestionsViewModel;
import interface_adapter.uploadQuestions.UploadQuestionsState;
import interface_adapter.manageQuiz.manageQuizViewModel;
import interface_adapter.manageQuiz.manageQuizController;
import interface_adapter.takeQuiz.takeQuizViewModel;
import interface_adapter.takeQuiz.takeQuizController;
import interface_adapter.takeQuiz.takeQuizState;
import interface_adapter.getDailyQuiz.GetDailyQuizViewModel;
import interface_adapter.getDailyQuiz.GetDailyQuizController;
import interface_adapter.getDailyQuiz.GetDailyQuizState;

import javax.swing.*;
import java.awt.*;
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
    private final ViewManagerModel viewManagerModel;
    private final CreateOwnQuestionsController createOwnQuestionsController;
    private final CreateOwnQuestionsViewModel createOwnQuestionsViewModel;
    private final GetApiQuestionsViewModel getApiQuestionsViewModel;
    private final UploadQuestionsController uploadQuestionsController;
    private final UploadQuestionsViewModel uploadQuestionsViewModel;
    private final manageQuizController manageQuizController;
    private final manageQuizViewModel manageQuizViewModel;
    private final takeQuizController takeQuizController;
    private final takeQuizViewModel takeQuizViewModel;
    private final GetDailyQuizController getDailyQuizController;
    private final GetDailyQuizViewModel getDailyQuizViewModel;
    private ArrayList<TestPanel> tests;
    private final JButton createQuestions, apiQuestions, uploadQuestions, getDailyQuiz, refreshTests;
    private final JPanel testContainer;

    public MainView(ViewManagerModel viewManagerModel,
                    CreateOwnQuestionsViewModel createOwnQuestionsViewModel,
                    CreateOwnQuestionsController createOwnQuestionsController,
                    GetApiQuestionsViewModel getApiQuestionsViewModel,
                    UploadQuestionsController uploadQuestionsController,
                    UploadQuestionsViewModel uploadQuestionsViewModel,
                    manageQuizController manageQuizController,
                    manageQuizViewModel manageQuizViewModel,
                    takeQuizController takeQuizController,
                    takeQuizViewModel takeQuizViewModel,
                    GetDailyQuizController getDailyQuizController,
                    GetDailyQuizViewModel getDailyQuizViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.createOwnQuestionsViewModel = createOwnQuestionsViewModel;
        this.createOwnQuestionsController = createOwnQuestionsController;
        this.getApiQuestionsViewModel = getApiQuestionsViewModel;
        this.uploadQuestionsController = uploadQuestionsController;
        this.uploadQuestionsViewModel = uploadQuestionsViewModel;
        this.manageQuizController = manageQuizController;
        this.manageQuizViewModel = manageQuizViewModel;
        this.takeQuizController = takeQuizController;
        this.takeQuizViewModel = takeQuizViewModel;
        this.getDailyQuizController = getDailyQuizController;
        this.getDailyQuizViewModel = getDailyQuizViewModel;

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

        createQuestions.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(createQuestions)) {
                            viewManagerModel.setActiveView(createOwnQuestionsViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                });
        apiQuestions.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(apiQuestions)) {
                            viewManagerModel.setActiveView(getApiQuestionsViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                });
        uploadQuestions.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(uploadQuestions)) {
                            UploadQuestionsState currentState = uploadQuestionsViewModel.getState();
                            currentState.setTestName(JOptionPane.showInputDialog(
                                    uploadQuestionsViewModel.TEST_NAME_LABEL));
                            currentState.setTxtPath(JOptionPane.showInputDialog(
                                    uploadQuestionsViewModel.TXT_PATH_LABEL));
                            uploadQuestionsController.execute(
                                    currentState.getTestName(),
                                    currentState.getTxtPath());
                            JOptionPane.showMessageDialog(
                                    MainView.this, currentState.getMessage());
                        }
                    }
                });
        getDailyQuiz.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(getDailyQuiz)) {
                            getDailyQuizController.execute();
                            GetDailyQuizState state = getDailyQuizViewModel.getState();
                            takeQuizController.start(state.getDailyTest());
                        }
                    }
                });
        refreshTests.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(refreshTests)) {
                            manageQuizController.refreshTest();
                            manageQuizState state = manageQuizViewModel.getState();
                            System.out.println(state.getTests());
                            updateTests(state.getTests());
                        }
                    }
                });
        tests = new ArrayList<>();

        JPanel leftSide = new JPanel();
        JPanel rightSide = new JPanel();

        leftSide.setLayout(new BoxLayout(leftSide, BoxLayout.Y_AXIS));
        buttons.setLayout(new GridLayout(0,1));
        leftSide.add(buttons);

        testContainer = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane. setPreferredSize(new Dimension(450, 450));
        scrollPane.setViewportView(testContainer);
        testContainer.add(new JLabel("Tests:"));
        testContainer.setLayout(new BoxLayout(testContainer, BoxLayout.Y_AXIS));

        rightSide.setLayout(new BoxLayout(rightSide, BoxLayout.Y_AXIS));
        rightSide.add(refreshTests);
        rightSide.add(scrollPane, BorderLayout.CENTER);

        this.setLayout(new GridLayout(0,2));

        this.add(leftSide);
        this.add(rightSide);

        manageQuizController.refreshTest();
        manageQuizState state = manageQuizViewModel.getState();
        System.out.println(state.getTests() + "tests");
        updateTests(state.getTests());
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("main act");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("main prp");
    }

    private void updateTests(Map<String, String[]> newTests) {
        for (TestPanel t: tests) {
            testContainer.remove(t);
        }
        tests.clear();
        System.out.println(newTests.keySet());
        for (String s: newTests.keySet()) {
            TestPanel t = new TestPanel(s, newTests.get(s)[0], newTests.get(s)[1]);
            tests.add(t);
            testContainer.add(t);
        }
        testContainer.revalidate();
    }

    private class TestPanel extends JPanel {
        TestPanel(String name, String comment, String stats) {

            JButton edit = new JButton("edit");
            JButton play = new JButton("play");
            JButton delete = new JButton("delete");

            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JPanel buttons = new JPanel();

            this.add(new JLabel(name));
            this.add(new JLabel(comment));
            if (stats != null) this.add(new JLabel("Best: " + stats + "%"));
            else this.add(new JLabel("Best: not taken yet!"));
            buttons.add(edit);
            buttons.add(play);
            buttons.add(delete);
            this.add(buttons);

            edit.addActionListener(
                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(edit)) {
                                String testName = JOptionPane.showInputDialog(
                                        "Enter the test you want to edit: ");
                                int questionNum = Integer.parseInt(JOptionPane.showInputDialog(
                                        "Enter the question number you want to edit: "));
                                String question = JOptionPane.showInputDialog(
                                        "Enter the new question: ");
                                String answer = JOptionPane.showInputDialog(
                                        "Enter the new answer: ");
                                ArrayList<String> incorrect = new ArrayList<String>();
                                String incorrect1 = JOptionPane.showInputDialog(
                                        "Enter the first incorrect answer: ");
                                String incorrect2 = JOptionPane.showInputDialog(
                                        "Enter the second incorrect answer: ");
                                String incorrect3 = JOptionPane.showInputDialog(
                                        "Enter the third incorrect answer: ");
                                incorrect.add(incorrect1);
                                incorrect.add(incorrect2);
                                incorrect.add(incorrect3);
                                createOwnQuestionsController.editExecute(testName, questionNum,
                                        question, answer, incorrect);
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
