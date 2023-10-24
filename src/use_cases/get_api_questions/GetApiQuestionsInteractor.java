package use_cases.get_api_questions;

public class GetApiQuestionsInteractor implements GetApiQuestionsInputBoundary {
    private final GetApiQuestionsInputData inputData;

    public GetApiQuestionsInteractor(GetApiQuestionsInputData inputData) {
        this.inputData = inputData;
    }


}
