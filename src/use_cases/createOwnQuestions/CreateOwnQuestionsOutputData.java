package use_cases.createOwnQuestions;

import entity.Question;

import java.util.List;

public class CreateOwnQuestionsOutputData{
    private List<Question> questionList;
    public CreateOwnQuestionsOutputData(List<Question> questionList) {
        this.questionList = questionList;
    }
}
