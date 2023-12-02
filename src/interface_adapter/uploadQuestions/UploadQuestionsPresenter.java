package interface_adapter.uploadQuestions;

import use_cases.uploadQuestions.UploadQuestionsOutputBoundary;

public class UploadQuestionsPresenter implements UploadQuestionsOutputBoundary {
    private final UploadQuestionsViewModel uploadQuestionsViewModel;

    public UploadQuestionsPresenter(UploadQuestionsViewModel uploadQuestionsViewModel) {
        this.uploadQuestionsViewModel = uploadQuestionsViewModel;
    }
    @Override
    public void prepareView(boolean successful) {
        UploadQuestionsState uploadQuestionsState = uploadQuestionsViewModel.getState();
        if (successful) {
            uploadQuestionsState.setMessage("Uploaded successfully!");
        } else {
            uploadQuestionsState.setMessage("Failed to upload. Test name exists!");
        }
        uploadQuestionsViewModel.firePropertyChanged();
    }
}
