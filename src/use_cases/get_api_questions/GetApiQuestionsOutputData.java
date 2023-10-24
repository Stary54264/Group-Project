package use_cases.get_api_questions;

public class GetApiQuestionsOutputData {
    private final boolean success;
    private final int testID;

    public GetApiQuestionsOutputData(boolean success, int testID) {
        this.success = success;
        this.testID = testID;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getTestID() {
        return testID;
    }
}
