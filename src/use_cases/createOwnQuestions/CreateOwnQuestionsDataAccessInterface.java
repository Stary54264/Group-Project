package src.use_cases.createOwnQuestions;

import entity.Question;

import java.util.List;

public interface CreateOwnQuestionsDataAccessInterface {
    void save(List<Question> questionList);
}
