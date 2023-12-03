package interface_adapter.createOwnQuestions;

import use_cases.createOwnQuestions.CreateOwnQuestionsOutputData;

import java.util.ArrayList;
import java.util.List;

public class CreateOwnQuestionsState {
    private List<String> questions = new ArrayList<String>();
    private String question = "";
    private String answer = "";
    private ArrayList<String> incorrect = new ArrayList<String>();
    private List<String> answers = new ArrayList<String>();
    private List<ArrayList<String>> incorrectAnswers = new ArrayList<ArrayList<String>>();

    private String error = "";

    public CreateOwnQuestionsState(CreateOwnQuestionsState copy) {
        this.questions = copy.questions;
        this.answers = copy.answers;
        this.incorrectAnswers = copy.incorrectAnswers;
        incorrect.add("");
        incorrect.add("");
        incorrect.add("");
    }
    public CreateOwnQuestionsState() {
        incorrect.add("");
        incorrect.add("");
        incorrect.add("");
    }
    public String getQuestion() {
        return question;
    }
    public List<String> getQuestions() {
        return questions;
    }
    public String getAnswer() {
        return answer;
    }
    public List<String> getAnswers() {
        return answers;
    }
    public ArrayList<String> getIncorrect() {
        return incorrect;
    }
    public List<ArrayList<String>> getIncorrectAnswers() {
        return incorrectAnswers;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public void setIncorrect(ArrayList<String> incorrect) {
        this.incorrect = incorrect;
    }

    public void addQuestions(String question) {
        questions.add(question);
    }
    public void addAnswers(String answer) {
        answers.add(answer);
    }
    public void addIncorrectAnswers(ArrayList<String> incorrect) {
        incorrectAnswers.add(incorrect);
    }

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
        this.questions.clear();
        this.answers.clear();
        this.incorrectAnswers.clear();
        this.error = "";
    }
}
