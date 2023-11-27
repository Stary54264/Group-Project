package interface_adapter.getResult;
public class GetResultState {
    private String result = "";
    public GetResultState(GetResultState copy) {
        result = copy.result;
    }
    public GetResultState() {}
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
