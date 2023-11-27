package data_access;

import entity.Question;
import entity.QuestionFactory;
import entity.Test;
import entity.TestFactory;
import use_cases.uploadQuestions.UploadQuestionsUserDataAccessInterface;
import java.io.*;
import java.util.ArrayList;

public class UploadFileDataAccessObject implements UploadQuestionsUserDataAccessInterface {
    private final ArrayList<Question> questions = new ArrayList<>();
    private final QuestionFactory questionFactory;
    private final TestFactory testFactory;

    public UploadFileDataAccessObject(QuestionFactory questionFactory, TestFactory testFactory) {
        this.questionFactory = questionFactory;
        this.testFactory = testFactory;
    }

    @Override
    public Test readTest(String testName, String csvPath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(csvPath)))) {
            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String questionContent = String.valueOf(col[0]);
                String correctAnswer = String.valueOf(col[1]);
                ArrayList<String> incorrectAnswers = new ArrayList<>();
                incorrectAnswers.add(String.valueOf(col[2]));
                incorrectAnswers.add(String.valueOf(col[3]));
                incorrectAnswers.add(String.valueOf(col[4]));
                questions.add(questionFactory.create(
                        questionContent, correctAnswer, incorrectAnswers));
            }
            return(testFactory.create(questions, testName));
        }
    }
}
