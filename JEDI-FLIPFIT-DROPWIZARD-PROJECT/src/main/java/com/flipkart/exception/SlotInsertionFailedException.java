package com.flipkart.exception;

/**
 * Exception for handling cases where slot insertion into the database fails.
 * This custom exception is thrown when an attempt to add a new time slot for gym sessions or appointments
 * does not succeed. Extending the standard Java {@link Exception} class, it provides a specific error message
 * tailored for failures related to inserting slots.
 *
 * Employing this exception allows for precise error handling related to slot management in the system,
 * facilitating clear feedback and appropriate actions in response to database operation failures.
 */
public class SlotInsertionFailedException extends Exception {

    /**
     * Overrides the {@link Exception#getMessage()} method to provide a custom error message specific
     * to slot insertion failures.
     *
     * @return A string message indicating that the slot insertion process has failed, useful for debugging
     * and informing the user of the need to possibly correct the data or retry the operation.
     */
    @Override
    public String getMessage() {
        return "Slot Insertion Failed";
    }
}

