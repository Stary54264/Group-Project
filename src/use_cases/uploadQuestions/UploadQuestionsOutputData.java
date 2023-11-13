package use_cases.uploadQuestions;

public class UploadQuestionsOutputData {
    private final String message;

    public UploadQuestionsOutputData() {
        this.message = "Successfully uploaded questions!";
    }

    public String getMessage(){
        return message;
    }
}
