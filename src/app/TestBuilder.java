package app;

import entity.Question;
import entity.Result;
import entity.Test;

import java.util.ArrayList;

public class TestBuilder {

    private String name, category, comment;
    private ArrayList<Question> questions;
    private ArrayList<Result> results;
    public TestBuilder () {
        results = new ArrayList<>();
        questions = new ArrayList<>();
    }
    public TestBuilder (Test t) {
        results = t.getResults();
        questions = t.getQuestions();
        comment = t.getComment();
        name = t.getName();
        category = t.getCategory();
    }
    public TestBuilder AddQuestion(Question q) {
        questions.add(q);
        return this;
    }

    public TestBuilder setCategory(String category) {this.category = category; return this;}

    public TestBuilder setComment(String comment) {this.comment = comment; return this;}

    public TestBuilder setName(String name) {this.name = name; return this;}

    public TestBuilder setQuestions(ArrayList<Question> questions) {this.questions = questions; return this;}
    public TestBuilder addQuestion(Question q) {this.questions.add(q); return this;}

    public Test Build() {
        Test t = new Test(name, category, questions, results);
        t.setComment(comment);
        return t;
    }
}