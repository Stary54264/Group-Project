package use_cases.getResult;
import use_cases.*;
import entity.*;

import java.util.ArrayList;

public class GetResultInteractor implements GetResultInputBoundary{
    final GetResultDataAccessInterface getResultDataAccessObject;
    final GetResultOutputBoundary getResultPresenter;
    public GetResultInteractor(GetResultDataAccessInterface getResultDataAccessInterface, GetResultOutputBoundary getResultOutputBoundary){
        this.getResultDataAccessObject = getResultDataAccessInterface;
        this.getResultPresenter = getResultOutputBoundary;
    }
    @Override
    public void execute(GetResultInputData getResultInputData) {
        String name = getResultInputData.getName();
        Test result = getResultDataAccessObject.getTest(name);
        ArrayList<Result> results = result.getResults();
        double sum = 0;
        for (Result r : results) {
            sum += r.getAverage();
        }
        double resultAverage = sum / results.size();
        String finalResult = Double.toString(resultAverage);
        GetResultOutputData getResultOutputData = new GetResultOutputData(finalResult);
        getResultPresenter.prepareSuccessView(getResultOutputData);
    }
}
