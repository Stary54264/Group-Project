package use_cases.createOwnQuestions;

import entity.Question;

import java.util.List;

public class CreateOwnQuestionsOutputData{
    private List<Question> questionList;
    public CreateOwnQuestionsOutputData(entity.Test test) {
        this.questionList = test.getQuestions();
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}
