package use_cases.getResult;
import entity.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GetResultInteractor implements GetResultInputBoundary {
    final GetResultDataAccessInterface getResultDataAccessObject;
    final GetResultOutputBoundary getResultPresenter;
    public GetResultInteractor(GetResultDataAccessInterface getResultDataAccessInterface, GetResultOutputBoundary getResultOutputBoundary){
        this.getResultDataAccessObject = getResultDataAccessInterface;
        this.getResultPresenter = getResultOutputBoundary;
    }
    @Override
    public void execute(GetResultInputData getResultInputData) {
        String name = getResultInputData.getName();
        Test test = getResultDataAccessObject.getTest(name);
        ArrayList<Result> results = test.getResults();
        Result lastResult = results.get(results.size()-1);
        boolean[] answers = lastResult.results();
        int right = 0, wrong = 0;
        for (boolean b: answers) {
            if (b) right++;
            else wrong++;
        }
        int newScore = right*100/(right+wrong);
        int pastScore = (test.getStats() == null) || (test.getStats().isEmpty())? -1 : Integer.parseInt(test.getStats());

        if (newScore > pastScore) {
            test.setStats(String.valueOf(newScore));
        }

        String score = String.format("Average: %d%% (Correct: %d, Wrong: %d) ", newScore, right, wrong);
        SimpleDateFormat dt1 = new SimpleDateFormat("mm:ss");
        String time = "Time taken: " + dt1.format(lastResult.timeTaken());

        GetResultOutputData getResultOutputData = new GetResultOutputData(score, time);

        getResultDataAccessObject.save(test);

        getResultPresenter.prepareSuccessView(getResultOutputData);
    }
}
