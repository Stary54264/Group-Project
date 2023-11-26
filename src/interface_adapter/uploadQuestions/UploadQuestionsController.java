package interface_adapter.uploadQuestions;

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