package app;

import data_access.FileUserDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsPresenter;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import interface_adapter.getApiQuestions.GetApiQuestionsController;
import interface_adapter.getApiQuestions.GetApiQuestionsPresenter;
import interface_adapter.getApiQuestions.GetApiQuestionsViewModel;
import interface_adapter.getResult.GetResultController;
import interface_adapter.getResult.GetResultPresenter;
import interface_adapter.getResult.GetResultViewModel;
import interface_adapter.manageQuiz.manageQuizController;
import interface_adapter.manageQuiz.manageQuizViewModel;
import use_cases.createOwnQuestions.CreateOwnQuestionsInteractor;
import use_cases.getApiQuestions.GetApiQuestionsInteractor;
import use_cases.getResult.GetResultInteractor;
import view.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Group Project");
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

        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject();

        CreateOwnQuestionsController createOwnQuestionsController = new CreateOwnQuestionsController(
                new CreateOwnQuestionsInteractor(new CreateOwnQuestionsPresenter(createOwnQuestionsViewModel),
                        fileUserDataAccessObject));
        GetApiQuestionsController getApiQuestionsController = new GetApiQuestionsController(
                new GetApiQuestionsInteractor(fileUserDataAccessObject,
                        new GetApiQuestionsPresenter())
        );
        GetResultController getResultController = new GetResultController(
                new GetResultInteractor(fileUserDataAccessObject,
                        new GetResultPresenter(viewManagerModel, getResultViewModel))
        );
        manageQuizController manageQuizController = new manageQuizController();

        CreateOwnQuestionsView createOwnQuestionsView = new CreateOwnQuestionsView(createOwnQuestionsController,
                createOwnQuestionsViewModel);
        views.add(createOwnQuestionsView, createOwnQuestionsView.viewname);
        GetAPIQuestionsView getApiQuestionsView = new GetAPIQuestionsView(getApiQuestionsController,
                getApiQuestionsViewModel);
        views.add(getApiQuestionsView, getApiQuestionsView.viewName);
        GetResultView getResultView = new GetResultView(getResultController, getResultViewModel);
        views.add(getResultView, getResultView.viewname);
        QuizView quizView = new QuizView(manageQuizController, manageQuizViewModel);
        views.add(quizView, quizView.viewname);
        MainView mainView = new MainView();
        views.add(mainView, mainView.viewname);

        viewManagerModel.setActiveView(mainView.viewname);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }
}
