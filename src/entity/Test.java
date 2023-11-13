package entity;

import java.util.ArrayList;
import java.util.List;
import entity.Question;
import entity.Result;

public class Test {
    private final ArrayList<Question> questions;
    private String category, name, comment;
    private final ArrayList<Result> results;

    public Test() {
        this.questions = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    public Test(ArrayList<Question> questions) {
        this.questions = questions;
        this.results = new ArrayList<>();
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions.clear();
        this.questions.addAll(questions);
    }

    public void setCategory(String category) {
        this.category = category;
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
