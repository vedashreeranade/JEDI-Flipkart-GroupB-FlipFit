package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

import java.util.List;

/**
 * Interface defining the operations available to customers in the system.
 * This includes managing bookings, retrieving gym information, and handling user account operations.
 */
public interface CustomerInterface {

	/**
	 * Cancels a slot booking for a customer.
	 *
	 * @param slotId The ID of the slot to be canceled.
	 * @return true if the slot is successfully canceled, false otherwise.
	 */
	boolean cancelSlots(int slotId);

	/**
	 * Retrieves all bookings associated with a specific user.
	 *
	 * @param userId The unique identifier of the user whose bookings are to be retrieved.
	 * @return List of Bookings objects detailing all bookings made by the user.
	 */
	List<Bookings> getAllBookings(String userId);

	/**
	 * Retrieves all gyms along with their available slots.
	 *
	 * @return A list of all Gyms with their respective slots included.
	 */
	List<Gym> getAllGymsWithSlots();

	/**
	 * Retrieves gyms based on their location area.
	 *
	 * @param area The geographic area to filter gyms by.
	 * @return A list of Gyms located in the specified area.
	 */
	List<Gym> getAllGymsByArea(String area);

	/**
	 * Books a slot for a gym session for a specified gym and time.
	 *
	 * @param gymId The ID of the gym where the booking is to be made.
	 * @param time The time slot to book.
	 * @param email The email of the user making the booking.
	 * @return true if the booking is successful, false if the booking fails.
	 */
	boolean bookSlots(int gymId, int time, String email);

	/**
	 * Validates a user's login credentials.
	 *
	 * @param username The username or email of the user.
	 * @param pass The password provided by the user.
	 * @return true if the credentials are correct, false otherwise.
	 */
	boolean validateUser(String username, String pass);

	/**
	 * Registers a new user in the system.
	 *
	 * @param user The User object containing the details of the new user.
	 */
	boolean createUser(User user);

	/**
	 * Verifies and updates the password for a gym user.
	 *
	 * @param email The email of the user whose password needs verification and updating.
	 * @param password The current password for verification.
	 * @param updatedPassword The new password to update to.
	 * @return true if the password is successfully updated, false if verification fails.
	 */
	boolean verifyGymUserPassword(String email, String password, String updatedPassword);

	/**
	 * Updates the password for a gym user.
	 *
	 * @param email The email of the user whose password is to be updated.
	 * @param password The current password for verification.
	 * @param updatedPassword The new password to set.
	 */
	boolean updateGymUserPassword(String email, String password, String updatedPassword);
}

