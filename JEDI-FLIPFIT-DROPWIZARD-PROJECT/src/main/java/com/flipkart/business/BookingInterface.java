package com.flipkart.business;

/**
 * Interface for managing bookings in the system.
 * This interface defines the essential operations for adding and canceling bookings related to gym sessions.
 */
public interface BookingInterface {

	/**
	 * Adds a new booking to the system.
	 * This method should be implemented to create a new booking record linking a user to a specific slot at a specific gym.
	 * Implementations should ensure that the slot is available and that no double booking occurs.
	 *
	 * @param userId The unique identifier for the user who is making the booking.
	 * @param slotId The unique identifier of the slot that is being booked.
	 * @param gymId The unique identifier of the gym where the slot is located.
	 */
	public void addBooking(String userId, String slotId, String gymId);

	/**
	 * Cancels an existing booking.
	 * This method should be implemented to remove a booking from the system. Implementations should handle checks
	 * such as ensuring the booking can still be canceled according to business rules (e.g., not too close to the slot time).
	 *
	 * @param bookingId The unique identifier of the booking to be canceled.
	 */
	public void cancelBooking(String bookingId);
}
