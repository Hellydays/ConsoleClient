package console;

public class BookNotFoundException extends Exception {

    public BookNotFoundException(String message, Throwable cause) {

    }

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(Throwable cause) {
        super(cause);
    }
}
