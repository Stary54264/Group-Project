package interface_adapter.getApiQuestions;

import app.Category;
import app.QuestionDifficulty;
import app.QuestionType;

public class GetApiQuestionsState {
    private String testName = "";
    private String testNameError = null;
    private int number = 0;
    private Category category = Category.AnyCategory;
    private QuestionType type = QuestionType.ALL;
    private QuestionDifficulty diff = QuestionDifficulty.ALL;

    public GetApiQuestionsState() {
    }
    public String getTestName() {return testName;}

    public String getTestNameError() {return testNameError;}

    public int getNumber() {return number;}

    public Category getCategory() {return category;}

    public QuestionType getType() {return type;}

    public QuestionDifficulty getDiff() {return diff;}

    public void setTestName(String name) {this.testName = name;}

    public void setTestNameError(String error) {this.testNameError = error;}

    public void setNumber(int number) {this.number = number;}

    public void setCategory(Category category) {this.category = category;}

    public void setType(QuestionType type) {this.type = type;}

    public void setDiff(QuestionDifficulty diff) {this.diff = diff;}

}
