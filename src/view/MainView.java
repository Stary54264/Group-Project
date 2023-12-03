package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsState;
import interface_adapter.getApiQuestions.GetApiQuestionsViewModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import interface_adapter.manageQuiz.manageQuizState;
import interface_adapter.uploadQuestions.UploadQuestionsController;
import interface_adapter.uploadQuestions.UploadQuestionsViewModel;
import interface_adapter.uploadQuestions.UploadQuestionsState;
import interface_adapter.manageQuiz.manageQuizViewModel;
import interface_adapter.manageQuiz.manageQuizController;
import interface_adapter.takeQuiz.takeQuizController;
import interface_adapter.getDailyQuiz.GetDailyQuizViewModel;
import interface_adapter.getDailyQuiz.GetDailyQuizController;
import interface_adapter.getDailyQuiz.GetDailyQuizState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

public class MainView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "Main Menu";
    private final CreateOwnQuestionsController createOwnQuestionsController;
    private final manageQuizController manageQuizController;
    private final manageQuizViewModel manageQuizViewModel;
    private final takeQuizController takeQuizController;
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
                    GetDailyQuizController getDailyQuizController,
                    GetDailyQuizViewModel getDailyQuizViewModel) {
        this.createOwnQuestionsController = createOwnQuestionsController;
        this.manageQuizController = manageQuizController;
        this.manageQuizViewModel = manageQuizViewModel;
        this.takeQuizController = takeQuizController;

        JPanel buttons = new JPanel();
        createQuestions = new JButton(CreateOwnQuestionsViewModel.TITLE_LABEL);
        apiQuestions = new JButton("API Questions");
        uploadQuestions = new JButton(UploadQuestionsViewModel.UPLOAD_BUTTON_LABEL);
        getDailyQuiz = new JButton("DAILY QUIZ");
        refreshTests = new JButton("REFRESH");

        buttons.add(new JPanel());
        buttons.add(createQuestions);
        buttons.add(apiQuestions);
        buttons.add(new JPanel());
        buttons.add(new JPanel());
        buttons.add(uploadQuestions);
        buttons.add(getDailyQuiz);
        buttons.add(new JPanel());

        createQuestions.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(createQuestions)) {
                            CreateOwnQuestionsState state = createOwnQuestionsViewModel.getState();
                            state.clearAll();
                            createOwnQuestionsViewModel.setState(state);
                            createOwnQuestionsViewModel.firePropertyChanged();
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
                                    UploadQuestionsViewModel.TEST_NAME_LABEL));
                            currentState.setTxtPath(JOptionPane.showInputDialog(
                                    UploadQuestionsViewModel.TXT_PATH_LABEL));
                            uploadQuestionsController.execute(
                                    currentState.getTestName(),
                                    currentState.getTxtPath());
                            JOptionPane.showMessageDialog(
                                    MainView.this, currentState.getMessage());
                            manageQuizController.refreshTests();
                            updateTests(manageQuizViewModel.getState().getTests());
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
                            if (state.isSuccess()) {
                                takeQuizController.start(state.getDailyTest());
                            } else {
                                JOptionPane.showMessageDialog(
                                        null, "Failed to create Daily Quiz");
                            }
                        }
                    }
                });
        refreshTests.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(refreshTests)) {
                            manageQuizController.refreshTests();
                            manageQuizState state = manageQuizViewModel.getState();
                            System.out.println(state.getTests());
                            updateTests(state.getTests());
                        }
                    }
                });

        JLabel titleName = new JLabel("Program");
        JPanel title = new JPanel();
        title.add(titleName);
        titleName.setFont(new Font("SansSerif", Font.BOLD, 32));
        JPanel rightSide = new JPanel();

        GridLayout buttonLayout = new GridLayout(2,4);
        buttonLayout.setHgap(7);
        buttonLayout.setVgap(7);
        buttons.setLayout(buttonLayout);

        testContainer = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane. setPreferredSize(new Dimension(450, 450));
        scrollPane.setViewportView(testContainer);
        testContainer.add(new JLabel("Tests:"));
        testContainer.setLayout(new BoxLayout(testContainer, BoxLayout.Y_AXIS));

        rightSide.setLayout(new BoxLayout(rightSide, BoxLayout.Y_AXIS));
        rightSide.add(refreshTests);
        rightSide.add(scrollPane, BorderLayout.CENTER);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        add(title, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        add(buttons, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 2;
        c.gridwidth = 1;
        add(rightSide, c);

        manageQuizController.refreshTests();
        manageQuizState state = manageQuizViewModel.getState();
        System.out.println(state.getTests() + "tests");
        updateTests(state.getTests());
        this.manageQuizViewModel.addPropertyChangeListener(this);
    }

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        manageQuizController.refreshTests();
        updateTests(manageQuizViewModel.getState().getTests());
    }

    private void updateTests(Map<String, String[]> newTests) {
        testContainer.removeAll();
        System.out.println(newTests.keySet());
        for (String s: newTests.keySet()) {
            TestPanel t = new TestPanel(s, newTests.get(s)[0], newTests.get(s)[1]);
            testContainer.add(t);
            testContainer.add(Box.createVerticalStrut(5));
        }
        testContainer.revalidate();
    }

    private class TestPanel extends JPanel {
        TestPanel(String name, String comment, String stats) {

            JButton edit = new JButton("edit");
            JButton play = new JButton("play");
            JButton delete = new JButton("delete");

            //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


            JPanel titlePanel = new JPanel();
            BorderLayout blayout = new BorderLayout();
            blayout.setHgap(10);
            titlePanel.setLayout(blayout);
            titlePanel.setBackground(Color.lightGray);

            JLabel nameLabel = new JLabel(name);
            nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

            titlePanel.add(nameLabel, BorderLayout.LINE_START);

            titlePanel.setBorder(new EmptyBorder(7, 7, 7, 7));
            if (stats != null && !stats.isEmpty()) titlePanel.add(new JLabel("Best: " + stats + "%"), BorderLayout.CENTER);
            else titlePanel.add(new JLabel("Best: not taken yet!"), BorderLayout.CENTER);


            JPanel buttons = new JPanel();
            buttons.setBackground(Color.lightGray);
            buttons.setLayout(new GridLayout(0,1));
            buttons.add(edit);
            buttons.add(play);
            buttons.add(delete);
            //this.add(buttons, BorderLayout.NORTH);
            this.setBackground(Color.lightGray);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));


            JPanel centralPanel = new JPanel();
            JLabel comme = new JLabel(comment);
            comme.setHorizontalAlignment(JLabel.CENTER);
            comme.setVerticalAlignment(JLabel.CENTER);

            centralPanel.add(comme, BorderLayout.CENTER);
            //add(centralPanel, BorderLayout.CENTER);

            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;
            c.weightx = 1;
            add(titlePanel, c);

            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            c.gridy = 1;
            c.weightx = 0;
            c.weighty = 1;
            add(centralPanel, c);

            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 1;
            c.gridy = 0;
            c.gridheight = 2;
            add(buttons, c);

            edit.addActionListener(
                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(edit)) {
                                createOwnQuestionsController.editExecute(name);
                            }
                        }
                    }
            );
            play.addActionListener(
                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(play)) {
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
                                if (JOptionPane.showConfirmDialog(delete, "Are you sure?") == 0) {
                                    manageQuizController.deleteTest(name);
                                    updateTests(manageQuizViewModel.getState().getTests());
                                }
                            }
                        }
                    }
            );
        }
    }
}
