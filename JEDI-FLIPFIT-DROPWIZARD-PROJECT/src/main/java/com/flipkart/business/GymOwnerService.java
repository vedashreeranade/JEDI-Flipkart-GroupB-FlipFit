package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.GymOwnerDAOImplementation;
import com.flipkart.dao.GymOwnerDaoInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * GymOwnerService provides the implementation of GymOwnerInterface, allowing gym owners
 * to manage their gyms, view gyms, validate credentials, and update their information.
 */
public class GymOwnerService implements GymOwnerInterface {

	// A HashMap to store gym owners with their email as the key
	HashMap<String, GymOwner> gymOwners = new HashMap();

	// DAO interface to interact with the data layer
	GymOwnerDaoInterface gymOwnerDaoInterface = new GymOwnerDAOImplementation();
	Scanner obj = new Scanner(System.in);
	int id = 0;

	/**
	 * Adds a new gym with available slots.
	 * @param gym The Gym object containing details of the gym to be added.
	 */
	@Override
	public void addGymWithSlots(Gym gym) {
		gymOwnerDaoInterface.addGym(gym);
	}

	/**
	 * Retrieves a list of gyms owned by a specific gym owner.
	 * @param userId The ID of the gym owner.
	 * @return A list of gyms owned by the gym owner.
	 */
	@Override
	public List<Gym> viewMyGyms(String userId) {
		return gymOwnerDaoInterface.viewGymSlots(userId);
	}

	/**
	 * Retrieves a list of all gyms, including those not owned by the specified gym owner.
	 * @param userId The ID of the gym owner.
	 * @return A list of all gyms.
	 */
	public List<Gym> viewAllGyms(String userId) {
		System.out.println("Here in viewAllGyms in GymOwnerService\nowner id -> " + userId);
		return gymOwnerDaoInterface.viewAllGyms(userId);
	}

	/**
	 * Deletes a gym based on the provided gym ID.
	 * @param gymId The ID of the gym to be deleted.
	 * @return true if the gym was successfully deleted, false otherwise.
	 */
	public boolean deleteGymById(int gymId){
		return gymOwnerDaoInterface.deleteGymByID(gymId);
	}

	/**
	 * Validates the login credentials of a gym owner.
	 * @param email The email of the gym owner.
	 * @param password The password of the gym owner.
	 * @return true if the login credentials are valid, false otherwise.
	 */
	@Override
	public boolean validateLogin(String email, String password) {
		return gymOwnerDaoInterface.verifyGymOwnerPassword(email, password);
	}

	/**
	 * Validates a gym owner based on their email and password.
	 * @param email The email of the gym owner.
	 * @param pass The password of the gym owner.
	 * @return true if the gym owner's credentials are valid, false otherwise.
	 */
	@Override
	public boolean validateGymOwner(String email, String pass){
		return gymOwnerDaoInterface.validateGymOwner(email, pass);
	}

	/**
	 * Creates a new gym owner.
	 * @param gymOwner The GymOwner object containing details of the gym owner to be created.
	 */
	@Override
	public void createGymOwner(GymOwner gymOwner) {
		gymOwnerDaoInterface.newGymOwner(gymOwner);
	}

	/**
	 * Verifies the password of a gym owner.
	 * @param email The email of the gym owner.
	 * @param password The password of the gym owner.
	 * @return true if the password is correct, false otherwise.
	 */
	@Override
	public boolean verifyGymOwnerPassword(String email, String password) {
		return gymOwnerDaoInterface.verifyGymOwnerPassword(email, password);
	}

	/**
	 * Updates the password of a gym owner.
	 * @param email The email of the gym owner.
	 * @param password The current password of the gym owner.
	 * @param updatedPassword The new password to be set.
	 */
	@Override
	public void updateGymOwnerPassword(String email, String password, String updatedPassword) {
		gymOwnerDaoInterface.updateGymOwnerPassword(email, password, updatedPassword);
	}

}