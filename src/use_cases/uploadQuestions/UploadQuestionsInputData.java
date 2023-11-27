package use_cases.uploadQuestions;

public class UploadQuestionsInputData {
    final private String testName;
    final private String jsonPath;

    public UploadQuestionsInputData(String testName, String jsonPath) {
        this.testName = testName;
        this.jsonPath = jsonPath;
    }

    String getTestName() {
        return testName;
    }

    String getJsonPath() {
        return jsonPath;
    }
}
