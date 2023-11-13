package src.use_cases.getApiQuestions;

public class GetApiQuestionsInteractor implements GetApiQuestionsInputBoundary {
    private final GetApiQuestionsInputData inputData;

    public GetApiQuestionsInteractor(GetApiQuestionsInputData inputData) {
        this.inputData = inputData;
    }


}
