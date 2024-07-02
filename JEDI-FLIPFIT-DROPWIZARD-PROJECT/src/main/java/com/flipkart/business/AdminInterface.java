package com.flipkart.business;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

import java.util.List;

/**
 * Interface for administrative functions within the system.
 * This interface provides methods for viewing and verifying details of gym owners and gyms,
 * as well as retrieving lists of unverified entities and general user information.
 */
public interface AdminInterface {

    /**
     * Retrieves a list of all gym owners registered in the system.
     *
     * @return A list of {@link GymOwner} instances representing all gym owners.
     */
    List<GymOwner> viewGymOwners();

    /**
     * Retrieves a list of all gyms registered in the system.
     *
     * @return A list of {@link Gym} instances representing all gyms.
     */
    List<Gym> viewGyms();

    /**
     * Retrieves a list of all users registered in the system.
     *
     * @return A list of {@link User} instances representing all users.
     */
    List<User> viewUsers();

    /**
     * Verifies the registration details of a specific gym identified by its ID.
     *
     * @param gymId The unique identifier for the gym to verify.
     * @return true if the gym is successfully verified, false otherwise.
     */
    boolean verifyGym(int gymId);

    /**
     * Verifies the registration details of a specific gym owner identified by their ID.
     *
     * @param gymOwnerId The unique identifier for the gym owner to verify.
     * @return true if the gym owner is successfully verified, false otherwise.
     */
    boolean verifyGymOwner(int gymOwnerId);

    /**
     * Retrieves a list of all gym owners who have not yet been verified.
     *
     * @return A list of {@link GymOwner} instances representing all unverified gym owners.
     */
    List<GymOwner> getUnverifiedGymOwners();

    /**
     * Retrieves a list of all gyms that have not yet been verified.
     *
     * @return A list of {@link Gym} instances representing all unverified gyms.
     */
    List<Gym> getUnverifiedGyms();
}
