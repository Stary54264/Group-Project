package interface_adapter.uploadQuestions;

import use_cases.uploadQuestions.UploadQuestionsOutputBoundary;

public class UploadQuestionsPresenter implements UploadQuestionsOutputBoundary {
    private final UploadQuestionsViewModel uploadQuestionsViewModel;

    public UploadQuestionsPresenter(UploadQuestionsViewModel uploadQuestionsViewModel) {
        this.uploadQuestionsViewModel = uploadQuestionsViewModel;
    }
    @Override
    public void prepareView(String message) {
        UploadQuestionsState uploadQuestionsState = uploadQuestionsViewModel.getState();
        uploadQuestionsState.setMessage(message);
        uploadQuestionsViewModel.firePropertyChanged();
    }
}
