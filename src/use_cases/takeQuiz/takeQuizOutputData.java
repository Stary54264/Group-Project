package use_cases.takeQuiz;

import java.util.ArrayList;

public record takeQuizOutputData(
        String testName,
        String question,
        ArrayList<String> answers,
        boolean lastCorrect,
        String lastAnswer
) {}
