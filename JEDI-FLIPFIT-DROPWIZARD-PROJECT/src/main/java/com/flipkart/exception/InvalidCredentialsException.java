package com.flipkart.exception;

/**
 * Exception for handling cases where invalid credentials are provided.
 * This exception is thrown when an authentication attempt fails due to incorrect username or password.
 * It extends the standard Java {@link Exception} class, providing a custom message for invalid credentials.
 *
 * Use this exception to specifically catch and handle authentication errors, allowing for clearer and more
 * precise error reporting in your application's login or security related functions.
 */
public class InvalidCredentialsException extends Exception {

    /**
     * Overrides the {@link Exception#getMessage()} method to provide a custom error message specific
     * to invalid credential scenarios.
     *
     * @return A string message describing the nature of the error, advising the user to check and
     * enter correct credentials.
     */
    @Override
    public String getMessage() {
        return "Wrong credentials. Please enter correct credentials.";
    }
}
