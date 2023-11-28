package interface_adapter.uploadQuestions;

public class UploadQuestionsState {
    private String testName;
    private String jsonPath;
    private String message = "";

    public UploadQuestionsState(UploadQuestionsState copy) {
        testName = copy.testName;
        jsonPath = copy.jsonPath;
        message = copy.message;
    }

    public UploadQuestionsState() {
    }

    public String getTestName() {
        return testName;
    }

    public String getJsonPath() {
        return jsonPath;
    }

    public String getMessage() {
        return message;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
