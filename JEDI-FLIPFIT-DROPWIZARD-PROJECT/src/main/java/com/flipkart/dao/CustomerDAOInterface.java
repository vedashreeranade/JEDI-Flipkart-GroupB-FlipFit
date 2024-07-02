package com.flipkart.dao;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;

import java.util.List;
/**
 * CustomerDAOInterface defines the data access operations related to customers,
 * including managing user passwords, booking slots, retrieving gym information,
 * and managing user information.
 */
public interface CustomerDAOInterface {

    /**
     * Updates the password for a gym user.
     * @param email The email of the user.
     * @param password The current password of the user.
     * @param updatedPassword The new password to be set.
     * @return true if the password was successfully updated, false otherwise.
     */
    public boolean updateGymUserPassword(String email,String password, String updatedPassword);

    /**
     * Verifies the password of a gym user.
     * @param email The email of the user.
     * @param password The password of the user.
     * @return true if the password is correct, false otherwise.
     */
    public boolean verifyGymUserPassword(String email, String password);

    /**
     * Retrieves a list of all gyms.
     * @return A list of all gyms.
     */
    List<Gym> getAllGyms();

    /**
     * Books a slot at a specified gym for a given time and user.
     * @param gymId The ID of the gym.
     * @param time The time slot to be booked.
     * @param email The email of the user booking the slot.
     * @return true if the slot was successfully booked, false otherwise.
     */
    boolean bookSlot(int gymId, int time, String email);

    /**
     * Retrieves all bookings for a given user.
     * @param userId The ID of the user whose bookings are to be retrieved.
     * @return A list of all bookings made by the user.
     */
    List<Bookings> getAllBookingByUserID(String userId);

    /**
     * Cancels a slot booking based on the booking ID.
     * @param bookingId The ID of the booking to be cancelled.
     * @return true if the booking was successfully cancelled, false otherwise.
     */
    boolean cancelBooking(int bookingId);

    /**
     * Validates a user by checking the provided username and password.
     * @param username The username of the user.
     * @param pass The password of the user.
     * @return true if the username and password are valid, false otherwise.
     */
    boolean validateUser(String username, String pass);

    /**
     * Creates a new user.
     * @param user The User object containing the user's information.
     * @return true if the user was successfully created, false otherwise.
     */
    boolean createUser(User user);
}



