package data_access;

import app.QuestionBuilder;
import app.TestBuilder;
import entity.Question;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FileTestDataAccessObjectTest {
    @Test
    public void testFileTestDAO() {
        FileTestDataAccessObject dataAccessObject = new FileTestDataAccessObject();
        dataAccessObject.readTest("Testing test", "Quizzes/Testing test.txt");
        int sizeBefore = dataAccessObject.getTests().size();
        assert !dataAccessObject.existsByName("test1");
        QuestionBuilder questionBuilder = new QuestionBuilder();
        questionBuilder.setQuestionText("a");
        questionBuilder.setCorrectAnswer("1");
        ArrayList<String> curr = new ArrayList<String>();
        curr.add(String.valueOf(2));
        curr.add(String.valueOf(3));
        curr.add(String.valueOf(4));
        questionBuilder.setIncorrectAnswers(curr);
        Question question = questionBuilder.build();
        TestBuilder testBuilder = new TestBuilder();
        testBuilder.setName("test1");
        ArrayList<Question> questionArrayList = new ArrayList<Question>();
        questionArrayList.add(question);
        testBuilder.setQuestions(questionArrayList);
        entity.Test test1 = testBuilder.build();
        dataAccessObject.save(test1);
        assert sizeBefore == dataAccessObject.getTests().size();
        entity.Test copy = dataAccessObject.getTest("test1");
        assert test1 == copy;
        List<entity.Test> list = dataAccessObject.getTests();
        assert !list.isEmpty();
        dataAccessObject.deleteTest("test1");
        assert sizeBefore == dataAccessObject.getTests().size();

    }
}
