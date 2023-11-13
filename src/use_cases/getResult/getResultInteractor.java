package use_cases.getResult;

public class getResultInteractor implements getResultInputBoundary{
    final getResultDataAccessInterface getResultDataAccessObject;
    final getResultOutputBoundary getResultPresenter;
    public getResultInteractor(getResultDataAccessInterface getResultDataAccessInterface, getResultOutputBoundary getResultOutputBoundary){
        this.getResultDataAccessObject = getResultDataAccessInterface;
        this.getResultPresenter = getResultOutputBoundary;
    }
    public void execute(){
        String result = getResultDataAccessObject.getResult();
        getResultOutputData getResultOutputData = new getResultOutputData(result);
        getResultPresenter.prepareSuccessView(getResultOutputData);
    }


}
