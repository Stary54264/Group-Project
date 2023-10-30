package interface_adapter.upload_questions;

import use_cases.uploadQuestions.UploadQuestionsInputBoundary;

public class UploadQuestionsController {

    final UploadQuestionsInputBoundary UploadQuestionsUseCaseInteractor;
    public UploadQuestionsController(UploadQuestionsInputBoundary UploadQuestionsUseCaseInteractor) {
        this.UploadQuestionsUseCaseInteractor = UploadQuestionsUseCaseInteractor;
    }

    public void execute() {
        UploadQuestionsUseCaseInteractor.execute();
    }
}