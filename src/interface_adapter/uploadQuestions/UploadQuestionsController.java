package interface_adapter.UploadQuestions;

import use_cases.uploadQuestions.UploadQuestionsInputBoundary;

public class UploadQuestionsController {
    final UploadQuestionsInputBoundary uploadQuestionsUseCaseInteractor;

    public UploadQuestionsController(UploadQuestionsInputBoundary uploadQuestionsUseCaseInteractor){
        this.uploadQuestionsUseCaseInteractor = uploadQuestionsUseCaseInteractor;
    }

    public void execute(){
        uploadQuestionsUseCaseInteractor.execute();
    }
}
