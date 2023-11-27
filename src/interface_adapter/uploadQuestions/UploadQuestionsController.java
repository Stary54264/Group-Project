package interface_adapter.uploadQuestions;

import use_cases.uploadQuestions.UploadQuestionsInputBoundary;
import use_cases.uploadQuestions.UploadQuestionsInputData;

import java.io.IOException;

public class UploadQuestionsController {

    final UploadQuestionsInputBoundary UploadQuestionsUseCaseInteractor;
    public UploadQuestionsController(UploadQuestionsInputBoundary UploadQuestionsUseCaseInteractor) {
        this.UploadQuestionsUseCaseInteractor = UploadQuestionsUseCaseInteractor;
    }

    public void execute(String testName, String csvPath) {
        UploadQuestionsInputData uploadQuestionsInputData = new UploadQuestionsInputData(
                testName, csvPath);
        UploadQuestionsUseCaseInteractor.execute(uploadQuestionsInputData);
    }
}