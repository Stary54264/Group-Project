package use_cases.getDailyQuiz;

import app.Category;
import app.QuestionDifficulty;
import app.QuestionType;

public class GetDailyQuizInputData {
    private final int numberOfQuestions;
    private final Category questionCategory;
    private final QuestionType questionType;
    private final QuestionDifficulty difficulty;
    private final String testName;

    public GetDailyQuizInputData(int numberOfQuestions, Category questionCategory, QuestionType questionType,
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