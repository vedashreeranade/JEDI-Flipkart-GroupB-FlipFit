package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;

import java.util.List;

/**
 * Implementation of the AdminInterface providing services for administrative actions such as
 * viewing, verifying, and managing gym owners, gyms, and users.
 * This service acts as a bridge between the web layer and the data access layer, ensuring that
 * business logic is enforced before data is persisted or updated.
 */
public class AdminService implements AdminInterface {

	private AdminDAOInterface adminDaoInterface;

	/**
	 * Constructor for AdminService that initializes the AdminDAO interface.
	 * This sets up the necessary connections to the data access objects responsible for interacting with the database.
	 */
	public AdminService() {
		this.adminDaoInterface = new AdminDAOImplementation();
	}

	/**
	 * Retrieves a comprehensive list of all gym owners from the database.
	 * @return a list of GymOwner objects, each representing a gym owner.
	 */
	@Override
	public List<GymOwner> viewGymOwners() {
		return adminDaoInterface.viewGymOwners();
	}

	/**
	 * Retrieves a comprehensive list of all gyms from the database.
	 * @return a list of Gym objects, each representing a gym.
	 */
	@Override
	public List<Gym> viewGyms() {
		return adminDaoInterface.viewGyms();
	}

	/**
	 * Retrieves a comprehensive list of all users from the database.
	 * @return a list of User objects, each representing a user.
	 */
	@Override
	public List<User> viewUsers() {
		return adminDaoInterface.viewUsers();
	}

	/**
	 * Verifies the registration details of a specific gym identified by its ID.
	 * @param gymId the unique identifier for the gym to be verified.
	 * @return true if the gym is successfully verified, false otherwise.
	 */
	@Override
	public boolean verifyGym(int gymId) {
		return adminDaoInterface.verifyGyms(gymId);
	}

	/**
	 * Verifies the registration details of a specific gym owner identified by their ID.
	 * @param gymOwnerId the unique identifier for the gym owner to be verified.
	 * @return true if the gym owner is successfully verified, false otherwise.
	 */
	@Override
	public boolean verifyGymOwner(int gymOwnerId) {
		return adminDaoInterface.verifyGymOwners(gymOwnerId);
	}

	/**
	 * Retrieves a list of all gym owners who have not yet been verified.
	 * This helps in managing gym owners by ensuring that only verified entities interact with the system.
	 * @return a list of unverified GymOwner objects.
	 */
	@Override
	public List<GymOwner> getUnverifiedGymOwners() {
		return adminDaoInterface.getUnverifiedGymOwner();
	}

	/**
	 * Retrieves a list of all gyms that have not yet been verified.
	 * This is crucial for maintaining the integrity of gyms listed in the system.
	 * @return a list of unverified Gym objects.
	 */
	@Override
	public List<Gym> getUnverifiedGyms() {
		return adminDaoInterface.getUnverifiedGyms();
	}

}

