package use_cases.getDailyQuiz;

import data_access.FileTestDataAccessObject;
import interface_adapter.getDailyQuiz.GetDailyQuizController;
import interface_adapter.getDailyQuiz.GetDailyQuizPresenter;
import interface_adapter.getDailyQuiz.GetDailyQuizViewModel;
import org.junit.jupiter.api.Test;
import use_cases.getDailyQuiz.GetDailyQuizInteractor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
class GetDailyQuizInteractorTest {

    @Test
    void execute() {
        FileTestDataAccessObject fileUserDataAccessObject = new FileTestDataAccessObject();
        GetDailyQuizViewModel getDailyQuizViewModel = new GetDailyQuizViewModel();

        GetDailyQuizController getDailyQuizController = new GetDailyQuizController(
                new GetDailyQuizInteractor(
                        fileUserDataAccessObject,
                        new GetDailyQuizPresenter(getDailyQuizViewModel)
                )
        );

        Calendar today = Calendar.getInstance();
        today.clear(Calendar.HOUR); today.clear(Calendar.MINUTE); today.clear(Calendar.SECOND);
        Date date = today.getTime();

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String inActiveDate = format1.format(date);

        String testName = "DailyTest-" + inActiveDate;

        fileUserDataAccessObject.deleteTest(testName);
        getDailyQuizController.execute();
        assertTrue(fileUserDataAccessObject.existsByName(testName));
    }
}