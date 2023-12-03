package use_cases.uploadQuestions;

public class UploadQuestionsInputData {
    final private String testName;
    final private String txtPath;

    public UploadQuestionsInputData(String testName, String txtPath) {
        this.testName = testName;
        this.txtPath = txtPath;
    }

    String getTestName() {
        return testName;
    }

    String getTxtPath() {
        return txtPath;
    }
}
