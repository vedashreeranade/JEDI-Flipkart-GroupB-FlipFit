package com.flipkart.exception;

/**
 * Exception for handling cases where registration processes fail.
 * This custom exception is thrown when an attempt to register a new user, gym owner, or any other entity
 * in the system does not complete successfully. It extends the standard Java {@link Exception} class,
 * providing a specific error message for registration failures.
 *
 * This exception can be used to manage failures in registration workflows, allowing the application to
 * give clear feedback to the user and possibly to trigger additional logging or recovery actions.
 */
public class RegistrationFailedException extends Exception {

    /**
     * Overrides the {@link Exception#getMessage()} method to provide a custom error message specific
     * to registration failure scenarios.
     *
     * @return A string message that advises the user that the registration process has failed and
     * suggests trying again, possibly with different or corrected data.
     */
    @Override
    public String getMessage() {
        return "Registration Failed. Please try again.";
    }
}

