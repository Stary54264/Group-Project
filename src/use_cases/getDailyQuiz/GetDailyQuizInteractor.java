package use_cases.getDailyQuiz;

import app.QuestionDifficulty;
import app.QuestionType;
import entity.Question;
import entity.Test;

import java.util.ArrayList;

import static data_access.APIDataAccessObject.RetrieveQuestionsTrivia1;

public class GetDailyQuizInteractor implements GetDailyQuizInputBoundary {
    final GetDailyQuizDataAccessInterface apiDataAccessObject;
    final GetDailyQuizOutputBoundary apiPresenter;

    public GetDailyQuizInteractor(GetDailyQuizDataAccessInterface getDailyQuizDataAccessInterface,
                                     GetDailyQuizOutputBoundary getDailyQuizOutputBoundary) {
        this.apiDataAccessObject = getDailyQuizDataAccessInterface;
        this.apiPresenter = getDailyQuizOutputBoundary;
    }

    @Override
    public void execute(GetDailyQuizInputData getDailyQuizInputData) {

    }
}

