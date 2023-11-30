package entity;

import java.util.ArrayList;
import java.util.List;
import entity.Question;
import entity.Result;

public class Test {
    private final ArrayList<Question> questions;
    private String category, name, comment;
    private final ArrayList<Result> results;

    public Test(String name, String Category, ArrayList<Question> questions, ArrayList<Result> results) {
        this.questions = questions;
        this.results = results;
        this.name = name;
        this.category = Category;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions.clear();
        this.questions.addAll(questions);
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
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
    public void addResult(Result r) {results.add(r);}

    public String getCategory() {
        return category;
    }

    public String getComment() {
        return comment;
    }
}
