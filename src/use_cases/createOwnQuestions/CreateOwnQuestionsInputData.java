package use_cases.createOwnQuestions;

import app.QuestionBuilder;
import app.TestBuilder;
import entity.Question;
import entity.Test;
import java.util.ArrayList;
import java.util.List;

public class CreateOwnQuestionsInputData {

    private List<String> questions;
    private List<String> answers;
    private List<ArrayList<String>> incorrectAnswers;
    private String name;
    private String comment;
    private String category;
    private Test test;
    private TestBuilder tBuilder = new TestBuilder();
    public CreateOwnQuestionsInputData(List<String> questions, List<String> answers,
                                       List<ArrayList<String>> incorrectAnswers, String name,
                                       String comment, String category) {
        this.questions = questions;
        this.answers = answers;
        this.incorrectAnswers = incorrectAnswers;
        ArrayList<Question> output = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            QuestionBuilder builder = new QuestionBuilder();
            builder.setQuestionText(questions.get(i));
            builder.setCorrectAnswer(answers.get(i));
            builder.setIncorrectAnswers(incorrectAnswers.get(i));
            Question question = builder.build();
            output.add(i, question);

        }
        tBuilder.setName(name);
        tBuilder.setQuestions(output);
        tBuilder.setComment(comment);
        tBuilder.setCategory(category);
        this.test = tBuilder.build();
    }
    public Test getCreateTest(){
        return test;
    }
}
