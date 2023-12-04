package entity;

import app.Main;
import org.junit.jupiter.api.Test;


class TestTest {

    @Test
    void getQuestions() {
        Main.main();
    }

    @Test
    void otherTest() {
        entity.Test test = new entity.Test(null, null, null, null);
        test.setQuestions(null);
        test.setName(null);
        test.getCategory();
        TextQuestion textQuestion = new TextQuestion(null, null, null);
        textQuestion.setQuestion(null);
    }

}