package data_access;

import entity.Question;
import entity.QuestionFactory;
import entity.Test;
import entity.TestFactory;
import use_cases.uploadQuestions.UploadQuestionsUserDataAccessInterface;
import java.io.*;
import java.util.ArrayList;

public class UploadFileDataAccessObject implements UploadQuestionsUserDataAccessInterface {
    private final File csvFile;
    private final ArrayList<Question> questions = new ArrayList<>();
    private final Test test;
    private final QuestionFactory questionFactory;
    private TestFactory testFactory;

    public UploadFileDataAccessObject(String csvPath,
                                      QuestionFactory questionFactory,
                                      TestFactory testFactory) throws IOException {
        this.questionFactory = questionFactory;
        this.testFactory = testFactory;
        csvFile = new File(csvPath);
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
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
            this.test = testFactory.create(questions);
        }
    }

    @Override
    public Test readQuestions() {
        return test;
    }
}
