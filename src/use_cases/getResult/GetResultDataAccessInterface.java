package use_cases.getResult;
import entity.*;

public interface GetResultDataAccessInterface {
    Test getTest(String name);
    void save(Test test);
}
