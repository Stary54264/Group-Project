package use_cases.createOwnQuestions;

import app.QuestionBuilder;
import entity.TextQuestion;
import entity.Test;

import java.util.List;

public class CreateOwnQuestionsOutputData{
    private List<TextQuestion> questionList;
    private List<QuestionBuilder> questionBuilders;
    private String name, comment;
    public CreateOwnQuestionsOutputData(Test test) {
        this.questionList = test.getQuestions();
    }
    public CreateOwnQuestionsOutputData(String name, String comment, List<QuestionBuilder> questions) {
        this.name = name;
        this.comment = comment;
        this.questionBuilders = questions;
    }
    public List<TextQuestion> getQuestionList() {
        return questionList;
    }

    public String getComment() {
        return comment;
    }

    public String getName() {
        return name;
    }

    public List<QuestionBuilder> getQuestionBuilders() {
        return questionBuilders;
    }
}
