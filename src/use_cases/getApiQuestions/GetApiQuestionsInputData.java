package use_cases.getApiQuestions;

import app.Category;
import app.QuestionDifficulty;
import app.QuestionType;

public class GetApiQuestionsInputData {
    private final int numberOfQuestions;
    private final Category questionCategory;
    private final QuestionType questionType;
    private final QuestionDifficulty difficulty;
    private final String testName;

    public GetApiQuestionsInputData(int numberOfQuestions, Category questionCategory, QuestionType questionType,
                                    QuestionDifficulty difficulty, String testName) {
        this.numberOfQuestions = numberOfQuestions;
        this.questionCategory = questionCategory;
        this.questionType = questionType;
        this.difficulty = difficulty;
        this.testName = testName;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public Category getQuestionCategory() {
        return questionCategory;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public QuestionDifficulty getDifficulty() {
        return difficulty;
    }
    public String getTestName() { return testName; }
}