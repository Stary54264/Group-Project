package data_access;

import app.Category;
import app.QuestionDifficulty;
import app.QuestionType;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class APIDataAccessObjectTest {
    @Test
    public void testAPiDAO() {
        Category category = Category.Art;
        QuestionDifficulty difficulty = QuestionDifficulty.EASY;
        QuestionType type = QuestionType.MULTI;
        String trivia1 = APIDataAccessObject.RetrieveQuestionsTrivia1(1,
                category, difficulty, type);
        assert !Objects.requireNonNull(trivia1).isEmpty();
        String trivia2 = APIDataAccessObject.RetrieveQuestionsTrivia2();
        assert !Objects.requireNonNull(trivia2).isEmpty();
    }

    @Test
    public void testAPiDAO2() {
        Category category = Category.Art;
        QuestionDifficulty difficulty = QuestionDifficulty.MEDIUM;
        QuestionType type = QuestionType.MULTI;
        String trivia1 = APIDataAccessObject.RetrieveQuestionsTrivia1(1,
                category, difficulty, type);
        assert !Objects.requireNonNull(trivia1).isEmpty();
        String trivia2 = APIDataAccessObject.RetrieveQuestionsTrivia2();
        assert !Objects.requireNonNull(trivia2).isEmpty();
    }

    @Test
    public void testAPiDAO3() {
        Category category = Category.Art;
        QuestionDifficulty difficulty = QuestionDifficulty.HARD;
        QuestionType type = QuestionType.BOOL;
        String trivia1 = APIDataAccessObject.RetrieveQuestionsTrivia1(1,
                category, difficulty, type);
        assert !Objects.requireNonNull(trivia1).isEmpty();
        String trivia2 = APIDataAccessObject.RetrieveQuestionsTrivia2();
        assert !Objects.requireNonNull(trivia2).isEmpty();
    }
}
