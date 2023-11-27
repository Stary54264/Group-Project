package interface_adapter.uploadQuestions;

public class UploadQuestionsState {
    private String message = "";

    public UploadQuestionsState(UploadQuestionsState copy) {
        message = copy.message;
    }

    public UploadQuestionsState() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
