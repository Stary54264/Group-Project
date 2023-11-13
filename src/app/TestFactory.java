package app;

import entity.Question;
import entity.Test;

import java.util.ArrayList;

public class TestFactory {
    private Test test;

    private ArrayList<Question> questions;
    private String name, category, comment;

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public TestFactory() {
        test = new Test();
    }

    public TestFactory(Test t) {
        test = t;
        questions = t.getQuestions();
        name = t.getName();
        category = t.getCategory();
        comment = t.getComment();
    }

    public Test Build() {
        test.setName(name);
        test.setCategory(category);
        test.setComment(comment);
        test.setQuestions(questions);
        return test;
    }

}
