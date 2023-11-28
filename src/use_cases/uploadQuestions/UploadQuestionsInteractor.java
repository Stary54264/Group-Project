package use_cases.uploadQuestions;

import entity.Test;

public class UploadQuestionsInteractor implements UploadQuestionsInputBoundary {
    final UploadQuestionsUserDataAccessInterface userDataAccessObject;
    final UploadQuestionsOutputBoundary uploadQuestionsPresenter;

    public UploadQuestionsInteractor(
            UploadQuestionsUserDataAccessInterface userDataAccessInterface,
            UploadQuestionsOutputBoundary uploadQuestionsOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.uploadQuestionsPresenter = uploadQuestionsOutputBoundary;
    }

    @Override
    public void execute(UploadQuestionsInputData uploadQuestionsInputData) {
        String testName = uploadQuestionsInputData.getTestName();
        String jsonPath = uploadQuestionsInputData.getJsonPath();
        Test test = userDataAccessObject.readTest(testName, jsonPath);
        if (!userDataAccessObject.existsByName(testName)) {
            userDataAccessObject.save(test);
            uploadQuestionsPresenter.prepareView("Uploaded successfully!");
        }
        else {
            uploadQuestionsPresenter.prepareView("Test name already exist!");
        }
    }
}