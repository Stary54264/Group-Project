package use_cases.getDailyQuiz;

import app.QuestionDifficulty;
import app.QuestionType;
import app.TestBuilder;
import data_access.APIDataAccessObject;
import entity.Question;
import entity.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static data_access.APIDataAccessObject.RetrieveQuestionsTrivia1;

public class GetDailyQuizInteractor implements GetDailyQuizInputBoundary {
    final GetDailyQuizDataAccessInterface DataAccessObject;
    final GetDailyQuizOutputBoundary Presenter;

    public GetDailyQuizInteractor(GetDailyQuizDataAccessInterface getDailyQuizDataAccessInterface,
                                     GetDailyQuizOutputBoundary getDailyQuizOutputBoundary) {
        this.DataAccessObject = getDailyQuizDataAccessInterface;
        this.Presenter = getDailyQuizOutputBoundary;
    }

    @Override
    public void execute() {
        Calendar today = Calendar.getInstance();
        today.clear(Calendar.HOUR); today.clear(Calendar.MINUTE); today.clear(Calendar.SECOND);
        Date todayDate = today.getTime();
        String testName = "DAILY TEST " + todayDate.toString();
        Test dailyTest = DataAccessObject.getTest(testName);
        if (dailyTest == null) {
            dailyTest = new TestBuilder()
                    .setName(testName)
                    .setCategory("General")
                    .setQuestions(APIDataAccessObject.RetrieveQuestionsTrivia2())
                    .build();
        }
        Presenter.prepareSuccessView(new GetDailyQuizOutputData(true, dailyTest.getName()));
    }
}

