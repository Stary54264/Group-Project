package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnumsTest {
    @Test
    void testCategory() {
        Category animals = Category.getByName("Animals");
        assert animals != null;
        assertNull(Category.getByName("nothing"));
        assertEquals(animals.value, 27);
        assertEquals(animals.getName(), "Animals");
    }

    @Test
    void testDiff() {
        QuestionDifficulty easy = QuestionDifficulty.getByName("Easy");
        assert easy != null;
        assertNull(QuestionDifficulty.getByName("nothing"));
        assertEquals(easy.name, "Easy");
    }
    @Test
    void testType() {
        QuestionType animals = QuestionType.getByName("True/False");
        assert animals != null;
        assertNull(QuestionType.getByName("nothing"));
        assertEquals(animals.name, "True/False");
    }
}
