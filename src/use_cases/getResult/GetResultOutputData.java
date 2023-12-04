package use_cases.getResult;

public class GetResultOutputData {
    private final String score;
    private final String time;

    public GetResultOutputData(String score, String time) {

        this.score = score;
        this.time = time;
    }

    public String getScore() {
        return score;
    }

    public String getTime() {
        return time;
    }
}
