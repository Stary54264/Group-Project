package entity;

import java.util.Date;

public record Result(
        Date timeTaken,
        boolean[] results
) { }
