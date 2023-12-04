package use_cases.createOwnQuestions;

import app.TextQuestionBuilder;
import entity.TextQuestion;
import entity.Test;

import java.util.List;

public class CreateOwnQuestionsOutputData{
    private List<TextQuestion> questionList;
    private List<TextQuestionBuilder> questionBuilders;
    private String name, comment;
    public CreateOwnQuestionsOutputData(Test test) {
        this.questionList = test.getQuestions();
    }
    public CreateOwnQuestionsOutputData(String name, String comment, List<TextQuestionBuilder> questions) {
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

    public List<TextQuestionBuilder> getQuestionBuilders() {
        return questionBuilders;
    }
}
