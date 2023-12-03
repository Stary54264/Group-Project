package interface_adapter.getDailyQuiz;

public class GetDailyQuizState {
    private String dailyTest;
    private boolean success;

    public String getDailyTest() {
        return dailyTest;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setDailyTest(String dailyTest, boolean success) {
        this.dailyTest = dailyTest;
        this.success = success;
    }
}
