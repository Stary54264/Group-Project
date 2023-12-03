package use_cases.createOwnQuestions;

import app.QuestionBuilder;
import app.TestBuilder;
import entity.Question;
import entity.Test;
import java.util.ArrayList;
import java.util.List;

public class CreateOwnQuestionsInputData {
    private final Test test;
    public CreateOwnQuestionsInputData(String name, String comment, List<QuestionBuilder> questions) {
        TestBuilder tBuilder = new TestBuilder();
        ArrayList<Question> output = new ArrayList<>();
        for (QuestionBuilder questionBuilder : questions) {
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
