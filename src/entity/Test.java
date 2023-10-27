package entity;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private final ArrayList<Question> questions;
    private String category, name, comment;
    private final ArrayList<Result> results;

    public Test(ArrayList<Question> questions) {
        this.questions = questions;
        this.results = new ArrayList<>();
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public String getCategory() {
        return category;
    }

    public String getComment() {
        return comment;
    }
}
