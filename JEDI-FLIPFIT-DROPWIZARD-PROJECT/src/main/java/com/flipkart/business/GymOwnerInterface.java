package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

import java.util.List;

/**
 * GymOwnerInterface defines the operations that can be performed by a gym owner,
 * including managing gyms and gym slots, as well as gym owner authentication and management.
 */
public interface GymOwnerInterface {

    /**
     * Adds a new gym with available slots.
     * @param gym The Gym object containing details of the gym to be added.
     */
    void addGymWithSlots(Gym gym);

    /**
     * Retrieves a list of gyms owned by a specific gym owner.
     * @param userId The ID of the gym owner.
     * @return A list of gyms owned by the gym owner.
     */
    List<Gym> viewMyGyms(String userId);

    /**
     * Retrieves a list of all gyms, including those not owned by the specified gym owner.
     * @param userId The ID of the gym owner.
     * @return A list of all gyms.
     */
    List<Gym> viewAllGyms(String userId);

    /**
     * Deletes a gym based on the provided gym ID.
     * @param gymId The ID of the gym to be deleted.
     * @return true if the gym was successfully deleted, false otherwise.
     */
    boolean deleteGymById(int gymId);

    /**
     * Verifies the password of a gym owner.
     * @param email The email of the gym owner.
     * @param password The password of the gym owner.
     * @return true if the password is correct, false otherwise.
     */
    boolean verifyGymOwnerPassword(String email, String password);

    /**
     * Validates the login credentials of a gym owner.
     * @param email The email of the gym owner.
     * @param password The password of the gym owner.
     * @return true if the login credentials are valid, false otherwise.
     */
    boolean validateLogin(String email, String password);

    /**
     * Validates a gym owner based on their email and password.
     * @param email The email of the gym owner.
     * @param pass The password of the gym owner.
     * @return true if the gym owner's credentials are valid, false otherwise.
     */
    boolean validateGymOwner(String email, String pass);

    /**
     * Creates a new gym owner.
     * @param gymOwner The GymOwner object containing details of the gym owner to be created.
     */
    void createGymOwner(GymOwner gymOwner);

    /**
     * Updates the password of a gym owner.
     * @param email The email of the gym owner.
     * @param password The current password of the gym owner.
     * @param updatedPassword The new password to be set.
     */
    void updateGymOwnerPassword(String email, String password, String updatedPassword);
}