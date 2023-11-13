package use_cases.getApiQuestions;

import entity.Question;
import app.QuestionDifficulty;
import app.QuestionType;

import java.util.List;

public class GetApiQuestionsInputData {
    private final int numberOfQuestions;
    private final int questionCategory;
    private final QuestionType questionType;
    private final QuestionDifficulty difficulty;

    public GetApiQuestionsInputData(int numberOfQuestions, int questionCategory, QuestionType questionType,
                                    QuestionDifficulty difficulty) {
        this.numberOfQuestions = numberOfQuestions;
        this.questionCategory = questionCategory;
        this.questionType = questionType;
        this.difficulty = difficulty;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public int getQuestionCategory() {
        return questionCategory;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public QuestionDifficulty getDifficulty() {
        return difficulty;
    }
}