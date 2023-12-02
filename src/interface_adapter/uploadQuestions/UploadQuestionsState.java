package interface_adapter.uploadQuestions;

public class UploadQuestionsState {
    private String testName;
    private String txtPath;
    private String message = "";

    public UploadQuestionsState(UploadQuestionsState copy) {
        testName = copy.testName;
        txtPath = copy.txtPath;
        message = copy.message;
    }

    public UploadQuestionsState() {
    }

    public String getTestName() {
        return testName;
    }

    public String getTxtPath() {
        return txtPath;
    }

    public String getMessage() {
        return message;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setTxtPath(String txtPath) {
        this.txtPath = txtPath;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
