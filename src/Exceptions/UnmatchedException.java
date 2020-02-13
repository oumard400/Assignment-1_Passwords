package Exceptions;

/**
 * Custom exception when the initial and re-typing passwords don't match.
 */
@SuppressWarnings("serial")
public class UnmatchedException extends Exception {
    
    /**
     * This no-arg constructor defines the exception message for unmatched.
     */
    public UnmatchedException() {
        super("The passwords do not match");
    }
}
