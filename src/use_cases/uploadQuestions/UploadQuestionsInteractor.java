package use_cases.uploadQuestions;

import data_access.FileUserDataAccessObject;
import entity.Test;
import entity.TestFactory;

import java.io.IOException;

public class UploadQuestionsInteractor implements UploadQuestionsInputBoundary {
    final UploadQuestionsUserDataAccessInterface userDataAccessObject;
    final FileUserDataAccessObject fileUserDataAccessObject;
    final UploadQuestionsOutputBoundary uploadQuestionsPresenter;

    public UploadQuestionsInteractor(
            UploadQuestionsUserDataAccessInterface userDataAccessInterface,
            FileUserDataAccessObject fileUserDataAccessObject,
            UploadQuestionsOutputBoundary uploadQuestionsOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.fileUserDataAccessObject = fileUserDataAccessObject;
        this.uploadQuestionsPresenter = uploadQuestionsOutputBoundary;
    }

    @Override
    public void execute(UploadQuestionsInputData uploadQuestionsInputData) throws IOException {
        String testName = uploadQuestionsInputData.getTestName();
        String csvPath = uploadQuestionsInputData.getCsvPath();
        Test test = userDataAccessObject.readTest(testName, csvPath);
        if (!fileUserDataAccessObject.existsByName(testName)) {
            fileUserDataAccessObject.save(test);
            uploadQuestionsPresenter.prepareSuccessView("Uploaded successfully!");
        }
        else {
            uploadQuestionsPresenter.prepareFailView("Test name already exist!");
        }
    }
}