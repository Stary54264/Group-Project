package app;

import entity.Question;
import entity.Result;
import entity.Test;

import java.util.ArrayList;

public class TestBuilder {

    private String name, category, comment, stats;
    private ArrayList<Question> questions;
    private final ArrayList<Result> results;
    public TestBuilder () {
        name = "";
        category = "";
        comment = "";
        stats = "";
        results = new ArrayList<>();
        questions = new ArrayList<>();
    }

    public TestBuilder setCategory(String category) {this.category = category; return this;}

    public TestBuilder setComment(String comment) {this.comment = comment; return this;}

    public TestBuilder setName(String name) {this.name = name; return this;}

    public TestBuilder setStats(String stats) {this.stats = stats; return this;}

    public TestBuilder setQuestions(ArrayList<Question> questions) {this.questions = questions; return this;}

    public Test build() {
        if (name.isBlank() || category.isBlank() || questions.isEmpty() || questions.contains(null)) return null;
        Test t = new Test(name, category, questions, results);
        t.setStats(stats);
        t.setComment(comment);
        return t;
    }
}
