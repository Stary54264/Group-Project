package interface_adapter.uploadQuestions;

import interface_adapter.ViewManagerModel;
import use_cases.uploadQuestions.UploadQuestionsOutputBoundary;

public class UploadQuestionsPresenter implements UploadQuestionsOutputBoundary {
    private final UploadQuestionsViewModel uploadQuestionsViewModel;
    private ViewManagerModel viewManagerModel;

    public UploadQuestionsPresenter(UploadQuestionsViewModel uploadQuestionsViewModel,
                                    ViewManagerModel viewManagerModel) {
        this.uploadQuestionsViewModel = uploadQuestionsViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareView(String message) {
        UploadQuestionsState uploadQuestionsState = uploadQuestionsViewModel.getState();
        uploadQuestionsState.setMessage(message);
        uploadQuestionsViewModel.firePropertyChanged();
    }
}
