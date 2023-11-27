package interface_adapter.getResult;
import use_cases.getResult.GetResultOutputBoundary;
import use_cases.getResult.GetResultOutputData;
import interface_adapter.ViewManagerModel;


public class GetResultPresenter implements GetResultOutputBoundary {
    private final GetResultViewModel getResultViewModel;
    private final ViewManagerModel viewManagerModel;
    public GetResultPresenter(ViewManagerModel viewManagerModel, GetResultViewModel getResultViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.getResultViewModel = getResultViewModel;
    }
    @Override
    public void prepareSuccessView(GetResultOutputData response) {
        GetResultState getResultState = getResultViewModel.getState();
        getResultState.setResult(response.getResult());
        this.getResultViewModel.setGetResultState(getResultState);
        getResultViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(getResultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}