package src.use_cases.createOwnQuestions;

import entity.Question;

import java.util.ArrayList;
import java.util.List;

public class CreateOwnQuestionsInputData {
    private final List<String> questions;
    private final List<Integer> ids;
    private final List<String> answers;
    private final List<String[]> incorrectAnswers;

    public CreateOwnQuestionsInputData(List<String> questions, List<Integer> ids, List<String> answers, List<String[]> incorrectAnswers) {
        this.questions = questions;
        this.ids = ids;
        this.answers = answers;
        this.incorrectAnswers = incorrectAnswers;
    }
    public List<Question> getQuestions() {
        List<Question> output = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            Question question = new Question(ids.get(i), questions.get(i), answers.get(i), incorrectAnswers.get(i));
            output.add(i, question);
        }
        return output;
    }
}
