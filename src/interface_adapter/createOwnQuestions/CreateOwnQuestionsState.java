package interface_adapter.createOwnQuestions;

import app.TextQuestionBuilder;

import java.util.ArrayList;
import java.util.List;

public class CreateOwnQuestionsState {
    private final List<TextQuestionBuilder> builders;
    private String name, comment;
    private int page;
    private String error = "";

    public CreateOwnQuestionsState() {
        builders = new ArrayList<>();
        builders.add(new TextQuestionBuilder());
    }

    public CreateOwnQuestionsState(String name, String comment, List<TextQuestionBuilder> builders) {
        this.builders = builders;
        this.name = name;
        this.comment = comment;
        if (!builders.isEmpty()) page = builders.size()-1;
    }

    public List<TextQuestionBuilder> getBuilders() {
        return builders;
    }

    public TextQuestionBuilder getBuilderOnPage() {
        return builders.get(page);
    }

    public void forward() {
        page++;
        if (page == builders.size()) {
            builders.add(new TextQuestionBuilder());
        }
    }

    public void back() {
        if (page!=0) page--;
    }

    public int getPage() {
        return page;
    }

    public String getComment() {
        return comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public void clearAll() {
        builders.clear();
        builders.add(new TextQuestionBuilder());
        page = 0;
        name = "";
        comment = "";
        this.error = "";
    }
}
