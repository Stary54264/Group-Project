package use_cases.uploadQuestions;

import entity.Test;

public class UploadQuestionsInteractor implements UploadQuestionsInputBoundary {
    final UploadQuestionsDataAccessInterface dataAccessObject;
    final UploadQuestionsOutputBoundary uploadQuestionsPresenter;

    public UploadQuestionsInteractor(
            UploadQuestionsDataAccessInterface dataAccessInterface,
            UploadQuestionsOutputBoundary uploadQuestionsOutputBoundary) {
        this.dataAccessObject = dataAccessInterface;
        this.uploadQuestionsPresenter = uploadQuestionsOutputBoundary;
    }

    @Override
    public void execute(UploadQuestionsInputData uploadQuestionsInputData) {
        String testName = uploadQuestionsInputData.getTestName();
        String txtPath = uploadQuestionsInputData.getTxtPath();
        Test test = dataAccessObject.readTest(testName, txtPath);
        boolean successful = !dataAccessObject.existsByName(testName);
        if (successful) {
            dataAccessObject.save(test);
            uploadQuestionsPresenter.prepareView(successful);
        }
        else {
            uploadQuestionsPresenter.prepareView(!successful);
        }
    }
}
