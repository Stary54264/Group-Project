package use_cases.getResult;

import entity.Test;

public class GetResultInputData {
    final private String name;

    public GetResultInputData(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
