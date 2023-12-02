package use_cases.getDailyQuiz;

public class GetDailyQuizOutputData {
    private final boolean success;
    private final String testName;

    public GetDailyQuizOutputData(boolean success, String testName) {
        this.success = success;
        this.testName = testName;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getTestName() {
        return testName;
    }
}
