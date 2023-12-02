package use_cases.manageQuiz;

import java.util.Map;

public record manageQuizOutputData(
        Map<String, String[]> newTests
) { }
