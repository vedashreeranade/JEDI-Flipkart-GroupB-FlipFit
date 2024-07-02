package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;

import java.util.List;

/**
 * GymOwnerDaoInterface defines the data access operations related to gym owners,
 * including managing gyms, gym slots, and gym owner authentication and registration.
 */
public interface GymOwnerDaoInterface {

    /**
     * Updates the password of a gym owner in the database.
     * @param email Email of the gym owner whose password is being updated.
     * @param password Current password for validation.
     * @param updatedPassword New password to set.
     */
    public void updateGymOwnerPassword(String email,String password, String updatedPassword);

    /**
     * Verifies the password of a gym owner.
     * @param email Email of the gym owner.
     * @param password Password to verify.
     * @return true if the password is correct, otherwise false.
     */
    public boolean verifyGymOwnerPassword(String email, String password);

    /**
     * Inserts multiple slots associated with a specific gym into the database.
     * @param slots List of Slots objects to insert.
     * @param gymId ID of the gym these slots are associated with.
     */
    void insertSlots(List<Slots> slots, int gymId);

    /**
     * Retrieves all gyms along with their slots owned by a specific gym owner.
     * @param gymOwnerID ID of the gym owner.
     * @return List of gyms owned by the gym owner.
     */
    public List<Gym> viewGymSlots(String gymOwnerID);

    /**
     * Retrieves all gyms owned by a specific gym owner.
     * @param gymOwnerID ID of the gym owner.
     * @return List of gyms owned by the gym owner.
     */
    public List<Gym> viewAllGyms(String gymOwnerID);

    /**
     * Deletes a gym based on the provided gym ID.
     * @param gymId The ID of the gym to be deleted.
     * @return true if the gym was successfully deleted, false otherwise.
     */
    public boolean deleteGymByID(int gymId);

    /**
     * Adds a new gym to the database.
     * @param gym The Gym object containing details about the new gym to be added.
     */
    void addGym(Gym gym);

    /**
     * Registers a new gym owner in the system.
     * @param gymOwner The GymOwner object containing details about the new gym owner.
     */
    void newGymOwner(GymOwner gymOwner);

    /**
     * Validates the login credentials of a gym owner.
     * @param email The email of the gym owner.
     * @param password The password to verify.
     * @return true if the credentials match, false otherwise.
     */
    boolean validateLogin(String email, String password);

    /**
     * Validates a gym owner based on their email and password.
     * @param email The email of the gym owner.
     * @param pass The password of the gym owner.
     * @return true if the gym owner's credentials are valid, false otherwise.
     */
    boolean validateGymOwner(String email, String pass);

}