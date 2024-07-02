package com.flipkart.exception;

/**
 * Exception for handling cases where the requested slots are unavailable.
 * This custom exception is thrown when an attempt to book a slot in a gym fails because there are no
 * available slots at the specified time. It extends the standard Java {@link Exception} class and provides
 * a specific error message that is helpful for users trying to make a booking.
 *
 * Using this exception allows the application to manage slot availability issues effectively, giving clear
 * feedback to users about the unavailability and suggesting alternative actions such as choosing a different
 * gym or a different time slot in the same gym.
 */
public class SlotsUnavailableException extends Exception {

    /**
     * Overrides the {@link Exception#getMessage()} method to provide a custom error message tailored
     * to scenarios where no slots are available for booking.
     *
     * @return A string message that informs the user that the slots are currently unavailable and
     * suggests trying another gym or a different slot in the same gym, enhancing the user experience
     * by directing them towards possible alternatives.
     */
    @Override
    public String getMessage() {
        return "Slots unavailable. Please try another gym or different slot in the gym";
    }
}
