package use_cases.uploadQuestions;

public class UploadQuestionsInteractor implements UploadQuestionsInputBoundary {
    final UploadQuestionsUserDataAccessInterface userDataAccessObject;
    final UploadQuestionsOutputBoundary uploadQuestionsPresenter;

    public UploadQuestionsInteractor(UploadQuestionsUserDataAccessInterface userDataAccessInterface,
                           UploadQuestionsOutputBoundary uploadQuestionsOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.uploadQuestionsPresenter = uploadQuestionsOutputBoundary;
    }

    @Override
    public void execute() {
        userDataAccessObject.addQuestions()
        UploadQuestionsOutputData clearOutputData = new UploadQuestionsOutputData();
        uploadQuestionsPresenter.prepareSuccessView(clearOutputData);
    }
}