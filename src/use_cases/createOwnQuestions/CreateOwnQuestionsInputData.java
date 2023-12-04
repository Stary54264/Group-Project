package use_cases.createOwnQuestions;

import app.TextQuestionBuilder;
import app.TestBuilder;
import entity.TextQuestion;
import entity.Test;
import java.util.ArrayList;
import java.util.List;

public class CreateOwnQuestionsInputData {
    private final Test test;
    public CreateOwnQuestionsInputData(String name, String comment, List<TextQuestionBuilder> questions) {
        TestBuilder tBuilder = new TestBuilder();
        ArrayList<TextQuestion> output = new ArrayList<>();
        for (TextQuestionBuilder questionBuilder : questions) {
            output.add(questionBuilder.build());
        }
        tBuilder.setName(name);
        tBuilder.setQuestions(output);
        tBuilder.setComment(comment);
        tBuilder.setCategory("Any");
        this.test = tBuilder.build();
    }
    public Test getCreateTest(){
        return test;
    }
}
