package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Result {
    private final Date timeTaken;
    private final boolean[] results;
    private String comment;

    public Result(Date timeTaken, boolean[] results) {
        this.timeTaken = timeTaken;
        this.results = results;
    }

    public Date getTimeTaken() {
        return timeTaken;
    }

    public double getAverage() {
        double a = 0;
        for (boolean b: results) {
            if (!b) a++;
        }
        a /= results.length;
        return a;
    }

    public String getComment() {
        return comment;
    }
}
