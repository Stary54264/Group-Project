package use_cases.uploadQuestions;

import java.io.IOException;

public interface UploadQuestionsInputBoundary {
    void execute(UploadQuestionsInputData uploadQuestionsInputData) throws IOException;
}
