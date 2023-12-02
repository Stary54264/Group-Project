package use_cases.getApiQuestions;

public class GetApiQuestionsOutputData {
    private final String testName;

    public GetApiQuestionsOutputData(String testName) {
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }
}
