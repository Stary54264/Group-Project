package entity;

import java.util.Date;
import java.util.Map;

public class Result {
    private final Date timeTaken;
    private final Map<Integer, Question> results;
    private String comment;

    public Result(Date timeTaken, Map<Integer, Question> results) {
        this.timeTaken = timeTaken;
        this.results = results;
    }

    public Date getTimeTaken() {
        return timeTaken;
    }

    public double getAverage() {
        double a = 0;
        for (Question b: results.values()) {
            if (b != null) a++;
        }
        a /= results.values().size();
        return a;
    }

    public String getComment() {
        return comment;
    }
}
