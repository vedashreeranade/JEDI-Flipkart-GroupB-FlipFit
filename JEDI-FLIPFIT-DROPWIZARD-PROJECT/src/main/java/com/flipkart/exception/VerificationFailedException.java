package com.flipkart.exception;

/**
 * Exception for handling cases where verification processes fail.
 * This custom exception is thrown when any type of verification process within the system does not
 * complete successfully. This could involve user identity verification, document verification, or
 * any other scenario where verification is required and fails. It extends the standard Java {@link Exception}
 * class, providing a specific error message for verification failures.
 *
 * Using this exception helps to clearly manage and report failures in various verification processes,
 * allowing for appropriate error handling and feedback mechanisms in security-critical operations.
 */
public class VerificationFailedException extends Exception {

    /**
     * Overrides the {@link Exception#getMessage()} method to provide a custom error message specific
     * to verification failure scenarios.
     *
     * @return A string message indicating that the verification process has failed. This message
     * is useful for debugging, logging, and providing feedback to users about the need to address
     * verification issues or to contact support for further assistance.
     */
    @Override
    public String getMessage() {
        return "Verification Failed.";
    }
}
