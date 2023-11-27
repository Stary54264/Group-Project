package entity;

import java.util.ArrayList;

public interface TestFactory {
    Test create(ArrayList<Question> questions);
}
