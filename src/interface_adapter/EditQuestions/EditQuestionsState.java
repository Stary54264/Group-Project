package interface_adapter.EditQuestions;

import interface_adapter.createOwnQuestions.CreateOwnQuestionsState;

import java.util.ArrayList;
import java.util.List;

public class EditQuestionsState {
    private String question = "";
    private String answer = "";
    private ArrayList<String> incorrect = new ArrayList<String>();
    private String error = "";
    private String testName = "";
    private int questionNum = 0;

    public EditQuestionsState(EditQuestionsState copy) {
        this.question = copy.question;
        this.answer = copy.answer;
        incorrect.add("");
        incorrect.add("");
        incorrect.add("");
        this.testName = copy.testName;
        this.questionNum = copy.questionNum;
    }
    public EditQuestionsState() {

    }
    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
    public ArrayList<String> getIncorrect() {
        return incorrect;
    }
    public String getTestName() { return testName; }
    public int getQuestionNum() { return questionNum; }
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public void setIncorrect(ArrayList<String> incorrect) {
        this.incorrect = incorrect;
    }
    public void setTestName(String testName) { this.testName = testName; }
    public void setQuestionNum(int questionNum) { this.questionNum = questionNum; }

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public void clearAll() {
        this.question = "";
        this.answer = "";
        this.incorrect.clear();
        this.error = "";
    }
}
