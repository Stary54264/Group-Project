package data_access;

import app.Category;
import app.QuestionBuilder;
import app.QuestionDifficulty;
import app.QuestionType;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class APIDataAccessObjectTest {
    @Test
    public void testAPiDAO() {
        String[] args = new String[1];

        APIDataAccessObject.main(args);
        Category category = Category.Art;
        QuestionDifficulty difficulty = QuestionDifficulty.EASY;
        QuestionType type = QuestionType.MULTI;
        String trivia1 = APIDataAccessObject.RetrieveQuestionsTrivia1(1,
                category, difficulty, type);
        assert !Objects.requireNonNull(trivia1).isEmpty();
        String trivia2 = APIDataAccessObject.RetrieveQuestionsTrivia2();
        assert !Objects.requireNonNull(trivia2).isEmpty();

    }
}
