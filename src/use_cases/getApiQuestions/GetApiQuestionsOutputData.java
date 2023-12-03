package use_cases.getApiQuestions;

public class GetApiQuestionsOutputData {
    private final boolean success;
    private final String testName;

    public GetApiQuestionsOutputData(boolean success, String testName) {
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
