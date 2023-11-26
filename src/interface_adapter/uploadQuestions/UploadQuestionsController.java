package interface_adapter.uploadQuestions;

import use_cases.uploadQuestions.UploadQuestionsInputBoundary;
import use_cases.uploadQuestions.UploadQuestionsInputData;

public class UploadQuestionsController {

    final UploadQuestionsInputBoundary UploadQuestionsUseCaseInteractor;
    public UploadQuestionsController(UploadQuestionsInputBoundary UploadQuestionsUseCaseInteractor) {
        this.UploadQuestionsUseCaseInteractor = UploadQuestionsUseCaseInteractor;
    }

    public void execute(String testName, String filePath) {
        UploadQuestionsInputData uploadQuestionsInputData = new UploadQuestionsInputData(
                testName, filePath);
        UploadQuestionsUseCaseInteractor.execute(uploadQuestionsInputData);
    }
}