package interface_adapter.getResult;

import use_cases.getResult.GetResultInputBoundary;
import use_cases.getResult.GetResultInputData;

public class GetResultController {
    final GetResultInputBoundary getResultUseCaseInteractor;
    public GetResultController(GetResultInputBoundary getResultUseCaseInteractor) {
        this.getResultUseCaseInteractor = getResultUseCaseInteractor;
    }
    public void execute(String name) {
        GetResultInputData getResultInputData = new GetResultInputData(name);
        getResultUseCaseInteractor.execute(getResultInputData);
    }
}
