package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.dao.CustomerDAOInterface;

public class CustomerService implements CustomerInterface {

	CustomerDAOInterface customerDAOInterface = new CustomerDAOImplementation();

	@Override
	public boolean verifyGymUserPassword(String email, String password, String updatedPassword) {
		return false;
	}

	@Override
	public boolean cancelSlots(int bookingId) {
		return customerDAOInterface.cancelBooking(bookingId);
	}

	@Override
	public List<Bookings> getAllBookings(String userId) {
		return customerDAOInterface.getAllBookingByUserID(userId);
	}

	@Override
	public List<Gym> getAllGymsWithSlots() {
		return customerDAOInterface.getAllGyms();
	}

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

	@Override
	public boolean bookSlots(int gymId, int time, String email) {
		return customerDAOInterface.bookSlot(gymId, time, email);
	}

	@Override
	public boolean validateUser(String username, String pass) {
		return customerDAOInterface.validateUser(username, pass);
	}

	@Override
	public void createUser(User user) {
		customerDAOInterface.createUser(user);
	}

	@Override
	public void updateGymUserPassword(String email, String password, String updatedPassword) {
		customerDAOInterface.updateGymUserPassword(email, password, updatedPassword);
	}

}
