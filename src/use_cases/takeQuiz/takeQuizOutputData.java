package use_cases.takeQuiz;

import java.util.ArrayList;

public class takeQuizOutputData {
    private final String testName;
    private final String question;
    private final ArrayList<String> answers;

    public takeQuizOutputData(String testName, String question, ArrayList<String> answers) {
        this.testName = testName;
        this.question = question;
        this.answers = answers;
    }

    public String getTestName() {
        return testName;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }
}
