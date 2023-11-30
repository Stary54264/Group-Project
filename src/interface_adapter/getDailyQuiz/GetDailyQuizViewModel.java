package interface_adapter.getDailyQuiz;

public class GetDailyQuizViewModel {
    private GetDailyQuizState state;

    public void setState(GetDailyQuizState state) {
        this.state = state;
    }

    public GetDailyQuizState getState() {
        return state;
    }
}
