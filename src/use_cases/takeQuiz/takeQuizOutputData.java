package use_cases.takeQuiz;

import java.util.ArrayList;

public class takeQuizOutputData {
    private final String question;
    private final ArrayList<String> answers;

    public takeQuizOutputData(String question, ArrayList<String> answers) {

        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }
}
