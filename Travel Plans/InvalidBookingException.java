/**
 * This class describes a checked exception.
 * @author Richard Hansel
 * @version 1.0
 */
public class InvalidBookingException extends Exception {
    /**
     * A constructor that takes in String representing the exception’s message.
     * @param exceptionMessage String message.
     */
    public InvalidBookingException(String exceptionMessage) {
        super(exceptionMessage);
    }

    /**
     * A no-args constructor that has default message “Invalid booking type”.
     */
    public InvalidBookingException() {
        this("Invalid booking type");
    }
}

