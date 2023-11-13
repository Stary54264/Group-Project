package use_cases.getResult;
import use_cases.*;

public class GetResultInteractor implements GetResultInputBoundary{
    final GetResultDataAccessInterface getResultDataAccessObject;
    final GetResultOutputBoundary getResultPresenter;
    public GetResultInteractor(GetResultDataAccessInterface getResultDataAccessInterface, GetResultOutputBoundary getResultOutputBoundary){
        this.getResultDataAccessObject = getResultDataAccessInterface;
        this.getResultPresenter = getResultOutputBoundary;
    }
    @Override
    public void execute(GetResultInputData getResultInputData) {

        GetResultOutputData getResultOutputData = new GetResultOutputData(result);
        getResultPresenter.prepareSuccessView(getResultOutputData);
    }
}
