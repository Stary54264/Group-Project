package entity;

import java.util.ArrayList;

public class Test {
    private ArrayList<Question> questions;
    private final String category;
    private String name;
    private String comment;
    private String stats;
    private final ArrayList<Result> results;

    public Test(String name, String Category, ArrayList<Question> questions, ArrayList<Result> results) {
        this.questions = questions;
        this.results = results;
        this.name = name;
        this.category = Category;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getStats() {
        return stats;
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
