package ir.uni.data;

public class Response<T> {
    private Boolean status;
    private T result;
    private T error;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public T getError() {
        return error;
    }

    public void setError(T error) {
        this.error = error;
    }
}
