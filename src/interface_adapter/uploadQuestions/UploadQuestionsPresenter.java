package interface_adapter.uploadQuestions;

import use_cases.uploadQuestions.UploadQuestionsOutputBoundary;

public class UploadQuestionsPresenter implements UploadQuestionsOutputBoundary {
    private final UploadQuestionsViewModel uploadQuestionsViewModel;

    public UploadQuestionsPresenter(UploadQuestionsViewModel uploadQuestionsViewModel) {
        this.uploadQuestionsViewModel = uploadQuestionsViewModel;
    }
    @Override
    public void prepareView(boolean nameError, boolean fileError) {
        UploadQuestionsState uploadQuestionsState = uploadQuestionsViewModel.getState();
        if (nameError && fileError) {
            uploadQuestionsState.setMessage("Uploaded successfully!");
        } else if (!fileError) {
            uploadQuestionsState.setMessage("Failed to upload. File does not exist!");
        } else {
            uploadQuestionsState.setMessage("Failed to upload. Test name exists!");
        }
        uploadQuestionsViewModel.firePropertyChanged();
    }
}
