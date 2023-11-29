package app;

import data_access.FileTestDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsController;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsPresenter;
import interface_adapter.createOwnQuestions.CreateOwnQuestionsViewModel;
import use_cases.createOwnQuestions.CreateOwnQuestionsInteractor;
import interface_adapter.getApiQuestions.GetApiQuestionsController;
import interface_adapter.getApiQuestions.GetApiQuestionsPresenter;
import interface_adapter.getApiQuestions.GetApiQuestionsViewModel;
import use_cases.getApiQuestions.GetApiQuestionsInteractor;
import interface_adapter.getResult.GetResultController;
import interface_adapter.getResult.GetResultPresenter;
import interface_adapter.getResult.GetResultViewModel;
import use_cases.getResult.GetResultInteractor;
import interface_adapter.manageQuiz.manageQuizController;
import interface_adapter.manageQuiz.manageQuizPresenter;
import interface_adapter.manageQuiz.manageQuizViewModel;
import use_cases.manageQuiz.manageQuizInteractor;
import interface_adapter.takeQuiz.takeQuizController;
import interface_adapter.takeQuiz.takeQuizPresenter;
import interface_adapter.takeQuiz.takeQuizViewModel;
import use_cases.takeQuiz.takeQuizInteractor;
import interface_adapter.uploadQuestions.UploadQuestionsController;
import interface_adapter.uploadQuestions.UploadQuestionsPresenter;
import interface_adapter.uploadQuestions.UploadQuestionsViewModel;
import use_cases.uploadQuestions.UploadQuestionsInteractor;

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
        takeQuizViewModel takeQuizViewModel = new takeQuizViewModel();
        UploadQuestionsViewModel uploadQuestionsViewModel = new UploadQuestionsViewModel();

        FileTestDataAccessObject fileUserDataAccessObject = new FileTestDataAccessObject();

        CreateOwnQuestionsController createOwnQuestionsController = new CreateOwnQuestionsController(
                new CreateOwnQuestionsInteractor(
                        new CreateOwnQuestionsPresenter(createOwnQuestionsViewModel),
                        fileUserDataAccessObject
                )
        );
        GetApiQuestionsController getApiQuestionsController = new GetApiQuestionsController(
                new GetApiQuestionsInteractor(fileUserDataAccessObject,
                        new GetApiQuestionsPresenter()
                )
        );
        UploadQuestionsController uploadQuestionsController = new UploadQuestionsController(
            new UploadQuestionsInteractor(
                    fileUserDataAccessObject,
                    new UploadQuestionsPresenter(uploadQuestionsViewModel)
            )
        );
        GetResultController getResultController = new GetResultController(
                new GetResultInteractor(fileUserDataAccessObject,
                        new GetResultPresenter(viewManagerModel, getResultViewModel)
                )
        );
        manageQuizController manageQuizController = new manageQuizController(
                new manageQuizInteractor(
                        new manageQuizPresenter(manageQuizViewModel),
                        fileUserDataAccessObject
                )
        );

        takeQuizController takeQuizController = new takeQuizController(
                new takeQuizInteractor(
                        new takeQuizPresenter(takeQuizViewModel),
                        fileUserDataAccessObject
                )
        );

        CreateOwnQuestionsView createOwnQuestionsView = new CreateOwnQuestionsView(
                createOwnQuestionsController,
                createOwnQuestionsViewModel
        );
        GetAPIQuestionsView getApiQuestionsView = new GetAPIQuestionsView(
                getApiQuestionsController,
                getApiQuestionsViewModel
        );
        GetResultView getResultView = new GetResultView(getResultViewModel);
        QuizView quizView = new QuizView(
            takeQuizViewModel,
            takeQuizController,
            getResultController
        );
        MainView mainView = new MainView(
                createOwnQuestionsViewModel,
                createOwnQuestionsController,
                uploadQuestionsController,
                uploadQuestionsViewModel,
                manageQuizController,
                manageQuizViewModel,
                takeQuizController,
                takeQuizViewModel
        );

        views.add(createOwnQuestionsView, createOwnQuestionsView.viewname);
        views.add(getApiQuestionsView, getApiQuestionsView.viewName);
        views.add(getResultView, getResultView.viewname);
        views.add(quizView, quizView.viewname);
        views.add(mainView, mainView.viewname);

        viewManagerModel.setActiveView(mainView.viewname);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }
}
