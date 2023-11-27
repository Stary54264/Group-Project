package use_cases.uploadQuestions;

import data_access.FileUserDataAccessObject;
import entity.Test;
import app.TestBuilder;

import java.io.IOException;

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
            uploadQuestionsPresenter.prepareSuccessView("Uploaded successfully!");
        }
        else {
            uploadQuestionsPresenter.prepareFailView("Test name already exist!");
        }
    }
}