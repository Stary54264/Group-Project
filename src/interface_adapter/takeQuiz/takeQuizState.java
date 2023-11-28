package interface_adapter.takeQuiz;

public class takeQuizState {
    private String[] answers = new String[4];

    public String getAnswer(int i) {
        return answers[i];
    }
}
