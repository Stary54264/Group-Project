package data_access;

import entity.Question;
import app.QuestionBuilder;
import entity.Test;
import app.TestBuilder;
import use_cases.uploadQuestions.UploadQuestionsDataAccessInterface;
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
}
