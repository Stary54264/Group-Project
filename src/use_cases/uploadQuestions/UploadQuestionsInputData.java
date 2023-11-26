package use_cases.uploadQuestions;

public class UploadQuestionsInputData {
    final private String testName;
    final private String filePath;

    public UploadQuestionsInputData(String testName, String filePath) {
        this.testName = testName;
        this.filePath = filePath;
    }

    String getTestName() {
        return testName;
    }

    String getFilePath() {
        return filePath;
    }
}
