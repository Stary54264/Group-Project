package data_access;
import entity.Test;
import use_cases.takeQuiz.takeQuizDataAccessInterface;
public class FileUserDataAccessObject implements takeQuizDataAccessInterface{

    @Override
    public Test getTest(String name) {
        return null;
    }
}
