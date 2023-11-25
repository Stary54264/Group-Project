package entity;

import java.util.ArrayList;

public class CommonTestFactory implements TestFactory {
    private Test test;

    private ArrayList<Question> questions;
    private String name, category, comment;

    public CommonTestFactory setQuestions(ArrayList<Question> questions) { this.questions = questions; return this; }

    public CommonTestFactory setName(String name) { this.name = name; return this;}

    public CommonTestFactory setCategory(String category) {
        this.category = category; return this;
    }

    public CommonTestFactory setComment(String comment) {
        this.comment = comment; return this;
    }

    public CommonTestFactory() {
        test = new Test();
    }

    public CommonTestFactory(Test t) {
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

    @Override
    public Test create(ArrayList<Question> questions, String category, String testName, String comment) {
        return new CommonTestFactory().setQuestions(questions).setCategory(category).setComment(comment).setName(testName).Build();
    }
}
