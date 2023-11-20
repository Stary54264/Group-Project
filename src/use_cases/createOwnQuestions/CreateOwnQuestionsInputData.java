package src.use_cases.createOwnQuestions;

import entity.Question;
import entity.Test;
import java.util.ArrayList;
import java.util.List;

public class CreateOwnQuestionsInputData {
    private final List<String> questions;
    private final List<String> answers;
    private final List<ArrayList<String>> incorrectAnswers;
    private final Test test;

    public CreateOwnQuestionsInputData(List<String> questions, List<String> answers, List<ArrayList<String>> incorrectAnswers) {
        this.questions = questions;
        this.answers = answers;
        this.incorrectAnswers = incorrectAnswers;
        ArrayList<Question> output = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            Question question = new Question(questions.get(i), answers.get(i), incorrectAnswers.get(i));
            output.add(i, question);
        }
        this.test = new Test(output);
    }
    public Test getCreateTest(){
        return test;
    }
}
