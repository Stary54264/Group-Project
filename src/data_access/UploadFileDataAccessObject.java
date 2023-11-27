package data_access;

import entity.Question;
import app.QuestionBuilder;
import entity.Test;
import app.TestBuilder;
import use_cases.uploadQuestions.UploadQuestionsUserDataAccessInterface;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class UploadFileDataAccessObject {
    private final ArrayList<Question> questions = new ArrayList<>();
    private final QuestionBuilder questionBuilder;
    private final TestBuilder testBuilder;

    public UploadFileDataAccessObject(QuestionBuilder questionBuilder, TestBuilder testBuilder) {
        this.questionBuilder = questionBuilder;
        this.testBuilder = testBuilder;
    }

    public Test readTest(String testName, String csvPath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(csvPath)));
            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                ArrayList<String> incorrectAnswers = new ArrayList<>(Arrays.asList(
                        String.valueOf(col[2]), String.valueOf(col[3]), String.valueOf(col[4])));
                testBuilder.addQuestion(questionBuilder.
                        setQuestionText(String.valueOf(col[0])).
                        setCorrectAnswer(String.valueOf(col[1])).
                        setIncorrectAnswers(incorrectAnswers).build());
            }
        }
        catch (Exception E) {
        }
        return(testBuilder.setName(testName).setCategory("General").setComment("").build());
    }
}
