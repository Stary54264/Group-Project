package src.use_cases.getResult;
import src.*;

public class getResultInteractor implements getResultInputBoundary{
    final getResultDataAccessInterface getResultDataAccessObject;
    final getResultOutputBoundary getResultPresenter;
    public getResultInteractor(getResultDataAccessInterface getResultDataAccessInterface, getResultOutputBoundary getResultOutputBoundary){
        this.getResultDataAccessObject = getResultDataAccessInterface;
        this.getResultPresenter = getResultOutputBoundary;
    }

}
