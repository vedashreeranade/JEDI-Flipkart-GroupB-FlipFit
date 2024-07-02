package com.flipkart.business;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.dao.CustomerDAOInterface;

import java.util.ArrayList;
import java.util.List;
/**
 * CustomerService provides various services related to customers, including
 * booking slots, retrieving gym information, and managing user information.
 */
public class CustomerService implements CustomerInterface {

    // DAO interface to interact with the data layer
    CustomerDAOInterface customerDAOInterface = new CustomerDAOImplementation();

    /**
     * Verifies and updates the user's password.
     * Currently returns false as it is not implemented.
     * @param email The email of the user.
     * @param password The current password of the user.
     * @param updatedPassword The new password to be set.
     * @return true if the password was successfully updated, false otherwise.
     */
    @Override
    public boolean verifyGymUserPassword(String email, String password, String updatedPassword) {
        return false;
    }

    /**
     * Cancels a slot booking based on the booking ID.
     * @param bookingId The ID of the booking to be cancelled.
     * @return true if the booking was successfully cancelled, false otherwise.
     */
    @Override
    public boolean cancelSlots(int bookingId) {
        return customerDAOInterface.cancelBooking(bookingId);
    }

    /**
     * Retrieves all bookings for a given user.
     * @param userId The ID of the user whose bookings are to be retrieved.
     * @return A list of all bookings made by the user.
     */
    @Override
    public List<Bookings> getAllBookings(String userId) {
        return customerDAOInterface.getAllBookingByUserID(userId);
    }

    /**
     * Retrieves all gyms along with their available slots.
     * @return A list of all gyms with their slots.
     */
    @Override
    public List<Gym> getAllGymsWithSlots() {
        return customerDAOInterface.getAllGyms();
    }

    /**
     * Retrieves all gyms in a specified area.
     * @param area The area to filter gyms by.
     * @return A list of gyms located in the specified area.
     */
    @Override
    public List<Gym> getAllGymsByArea(String area) {
        List<Gym> allGyms = customerDAOInterface.getAllGyms();
        List<Gym> filteredGyms = new ArrayList<>();
        for (Gym gym : allGyms) {
            if (gym.getLocation() != null && gym.getLocation().equals(area)) {
                filteredGyms.add(gym);
            }
        }
        return filteredGyms;
    }

    /**
     * Books a slot at a specified gym for a given time and user.
     * @param gymId The ID of the gym.
     * @param time The time slot to be booked.
     * @param email The email of the user booking the slot.
     * @return true if the slot was successfully booked, false otherwise.
     */
    @Override
    public boolean bookSlots(int gymId, int time, String email) {
        return customerDAOInterface.bookSlot(gymId, time, email);
    }

    /**
     * Validates a user by checking the provided username and password.
     * @param username The username of the user.
     * @param pass The password of the user.
     * @return true if the username and password are valid, false otherwise.
     */
    @Override
    public boolean validateUser(String username, String pass) {
        return customerDAOInterface.validateUser(username, pass);
    }

    /**
     * Creates a new user.
     * @param user The user object containing the user's information.
     * @return true if the user was successfully created, false otherwise.
     */
    @Override
    public boolean createUser(User user) {
        return customerDAOInterface.createUser(user);
    }

    /**
     * Updates the password for a gym user.
     * @param email The email of the user.
     * @param password The current password of the user.
     * @param updatedPassword The new password to be set.
     * @return true if the password was successfully updated, false otherwise.
     */
    @Override
    public boolean updateGymUserPassword(String email, String password, String updatedPassword) {
        return customerDAOInterface.updateGymUserPassword(email, password, updatedPassword);
    }

}

//package com.flipkart.business;
//
//import com.flipkart.bean.Bookings;
//import com.flipkart.bean.Gym;
//import com.flipkart.bean.User;
//import com.flipkart.dao.CustomerDAOImplementation;
//import com.flipkart.dao.CustomerDAOInterface;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Service class for customer-related operations. This class interfaces with the DAO layer to
// * provide services like booking slots, retrieving gym details, managing user accounts, and more.
// */
//public class CustomerService implements CustomerInterface {
//
//	private CustomerDAOInterface customerDAOInterface = new CustomerDAOImplementation();
//
//	/**
//	 * Verifies and updates the gym user's password.
//	 * Note: This implementation always returns false and does not perform any operations.
//	 * @param email User's email to identify the account.
//	 * @param password User's current password for verification.
//	 * @param updatedPassword New password to update after verification.
//	 * @return always returns false.
//	 */
//	@Override
//	public boolean verifyGymUserPassword(String email, String password, String updatedPassword) {
//		return false;
//	}
//
//	/**
//	 * Cancels a slot booking based on the booking ID.
//	 * @param bookingId The ID of the booking to cancel.
//	 * @return true if the booking was successfully cancelled, false otherwise.
//	 */
//	@Override
//	public boolean cancelSlots(int bookingId) {
//		return customerDAOInterface.cancelBooking(bookingId);
//	}
//
//	/**
//	 * Retrieves all bookings made by a specific user.
//	 * @param userId The ID of the user whose bookings are to be retrieved.
//	 * @return List of Bookings objects.
//	 */
//	@Override
//	public List<Bookings> getAllBookings(String userId) {
//		return customerDAOInterface.getAllBookingByUserID(userId);
//	}
//
//	/**
//	 * Retrieves all gyms along with their available slots.
//	 * @return List of all Gym objects.
//	 */
//	@Override
//	public List<Gym> getAllGymsWithSlots() {
//		return customerDAOInterface.getAllGyms();
//	}
//
//	/**
//	 * Retrieves all gyms located in a specific area.
//	 * @param area The area to filter the gyms by.
//	 * @return List of filtered Gym objects that are located in the specified area.
//	 */
//	@Override
//	public List<Gym> getAllGymsByArea(String area) {
//		List<Gym> allGyms = customerDAOInterface.getAllGyms();
//		List<Gym> filteredGyms = new ArrayList<>();
//		for (Gym gym : allGyms) {
//			if (gym.getLocation() != null && gym.getLocation().equals(area)) {
//				filteredGyms.add(gym);
//			}
//		}
//		return filteredGyms;
//	}
//
//	/**
//	 * Books a slot for a gym session for a user at a specified time.
//	 * @param gymId The gym ID where the slot is to be booked.
//	 * @param time The time at which the slot is scheduled.
//	 * @param email The email of the user making the booking.
//	 * @return true if the booking is successful, false otherwise.
//	 */
//	@Override
//	public boolean bookSlots(int gymId, int time, String email) {
//		return customerDAOInterface.bookSlot(gymId, time, email);
//	}
//
//	/**
//	 * Validates a user's credentials.
//	 * @param username The username of the user.
//	 * @param pass The password of the user.
//	 * @return true if the credentials are valid, false otherwise.
//	 */
//	@Override
//	public boolean validateUser(String username, String pass) {
//		return customerDAOInterface.validateUser(username, pass);
//	}
//
//	/**
//	 * Creates a new user in the system.
//	 * @param user The User object containing details about the new user.
//	 */
//	@Override
//	public void createUser(User user) {
//		customerDAOInterface.createUser(user);
//	}
//
//	/**
//	 * Updates the password for a gym user.
//	 * @param email The email of the user whose password is to be updated.
//	 * @param password The current password for verification.
//	 * @param updatedPassword The new password to set.
//	 */
//	@Override
//	public void updateGymUserPassword(String email, String password, String updatedPassword) {
//		customerDAOInterface.updateGymUserPassword(email, password, updatedPassword);
//	}
//
//}
