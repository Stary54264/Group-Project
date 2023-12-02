package use_cases.getDailyQuiz;

import app.Serializer;
import app.TestBuilder;
import data_access.APIDataAccessObject;
import entity.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        Date date = today.getTime();

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String inActiveDate = format1.format(date);

        String testName = "DailyTest-" + inActiveDate;
        Test dailyTest = DataAccessObject.getTest(testName);
        if (dailyTest == null) {
            dailyTest = new TestBuilder()
                    .setQuestions(Serializer.ParseTrivia2(APIDataAccessObject.RetrieveQuestionsTrivia2()))
                    .setName(testName)
                    .setCategory("Any")
                    .build();
        }
        DataAccessObject.save(dailyTest);
        Presenter.prepareSuccessView(new GetDailyQuizOutputData(true, dailyTest.getName()));
    }
}

