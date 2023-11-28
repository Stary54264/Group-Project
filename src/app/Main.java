package app;

import data_access.FileTestDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import interface_adapter.getApiQuestions.GetApiQuestionsViewModel;
import interface_adapter.getResult.GetResultViewModel;
import interface_adapter.manageQuiz.manageQuizViewModel;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        CreateOwnQuestionsViewModel createOwnQuestionsViewModel = new CreateOwnQuestionsViewModel();
        GetApiQuestionsViewModel getApiQuestionsViewModel = new GetApiQuestionsViewModel();
        GetResultViewModel getResultViewModel = new GetResultViewModel();
        manageQuizViewModel manageQuizViewModel = new manageQuizViewModel();

        FileTestDataAccessObject userDataAccessObject;
        try {

        }

    }
}
