package interface_adapter.takeQuiz;

public class takeQuizState {
    private boolean finished;
    private String testName;
    private String question;
    private String[] answers = new String[4];

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    public boolean isFinished() {
        return finished;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getQuestion() {
        return question;
    }
    public void setTestName(String testName) {
        this.testName = testName;
    }
    public String getTestName() {
        return testName;
    }
    public String getAnswer(int i) {
        return answers[i];
    }
    public int getAnswerCount() {
        return answers.length;
    }
    public void setAnswers(String[] answers) {
        this.answers = answers;
    }
}
