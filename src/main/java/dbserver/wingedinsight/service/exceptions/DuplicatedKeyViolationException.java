package dbserver.wingedinsight.service.exceptions;

public class DuplicatedKeyViolationException extends RuntimeException {

    public DuplicatedKeyViolationException(String message) {
        super(message);
    }
}
