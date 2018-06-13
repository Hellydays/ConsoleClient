package console;

public class FailedConnectionException extends  Exception {

    public FailedConnectionException(String message, Throwable cause) {

    }
    public FailedConnectionException(String message) {
        super(message);
    }
    public FailedConnectionException(Throwable cause) {
        super(cause);
    }
}
