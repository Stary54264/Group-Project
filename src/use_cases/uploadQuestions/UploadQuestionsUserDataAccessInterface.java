package use_cases.uploadQuestions;

import entity.Test;

import java.io.IOException;

public interface UploadQuestionsUserDataAccessInterface {
    Test readTest(String testName, String csvPath) throws IOException;
}
