package use_cases.EditQuestions;

import app.QuestionBuilder;
import entity.Question;
import interface_adapter.EditQuestions.EditQuestionsController;

import java.util.ArrayList;
import java.util.List;

public class EditQuestionsInputData {
    private String testName;
    private int questionNum;
    private String questionText;
    private String answer;
    private ArrayList<String> incorrectAnswers;
    private QuestionBuilder questionBuilder = new QuestionBuilder();
    private Question question;
    public EditQuestionsInputData(String testName, int questionNum, String question,
                                  String answer, ArrayList<String> incorrectAnswers) {
        this.testName = testName;
        this.questionNum = questionNum;
        this.questionText = question;
        this.answer = answer;
        this.incorrectAnswers = incorrectAnswers;
        questionBuilder.setQuestionText(questionText);
        questionBuilder.setCorrectAnswer(answer);
        questionBuilder.setIncorrectAnswers(incorrectAnswers);
        this.question = questionBuilder.build();
    }
    public String getTestName() { return testName; }
    public int getQuestionNum() { return questionNum; }
    public Question getQuestion() { return question; }

}
