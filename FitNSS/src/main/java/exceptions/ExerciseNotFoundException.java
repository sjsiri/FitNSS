package exceptions;

public class ExerciseNotFoundException extends RuntimeException {
    /**
     * Exception with no message or cause.
     */
    public ExerciseNotFoundException() {
        super();
    }

    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public ExerciseNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public ExerciseNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public ExerciseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
