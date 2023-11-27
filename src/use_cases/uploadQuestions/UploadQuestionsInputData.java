package use_cases.uploadQuestions;

public class UploadQuestionsInputData {
    final private String testName;
    final private String csvPath;

    public UploadQuestionsInputData(String testName, String csvPath) {
        this.testName = testName;
        this.csvPath = csvPath;
    }

    String getTestName() {
        return testName;
    }

    String getCsvPath() {
        return csvPath;
    }
}
