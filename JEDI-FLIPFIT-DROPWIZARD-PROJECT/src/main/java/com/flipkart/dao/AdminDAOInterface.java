package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import java.util.List;

/**
 * Interface defining the database access operations that need to be implemented for administrative management of gyms, users, and gym owners.
 */
public interface AdminDAOInterface {

    /**
     * Retrieves a list of all gyms from the database.
     * @return a list of all gyms in the form of Gym objects
     */
    public List<Gym> viewGyms();

    /**
     * Retrieves a list of all users from the database.
     * @return a list of all users in the form of User objects
     */
    public List<User> viewUsers();

    /**
     * Retrieves a list of all gym owners from the database.
     * @return a list of all gym owners in the form of GymOwner objects
     */
    public List<GymOwner> viewGymOwners();

    /**
     * Verifies the gym owners based on their ID by updating their status to 'verified' in the database.
     * @param id The ID of the gym owner to verify
     * @return true if the operation was successful, false otherwise
     */
    public boolean verifyGymOwners(int id);

    /**
     * Verifies gyms based on their ID by updating their status to 'verified' in the database.
     * @param id The ID of the gym to verify
     * @return true if the operation was successful, false otherwise
     */
    public boolean verifyGyms(int id);

    /**
     * Retrieves a list of all gyms that are currently marked as unverified in the database.
     * @return a list of unverified gyms in the form of Gym objects
     */
    public List<Gym> getUnverifiedGyms();

    /**
     * Retrieves a list of all gym owners that are currently marked as unverified in the database.
     * @return a list of unverified gym owners in the form of GymOwner objects
     */
    public List<GymOwner> getUnverifiedGymOwner();
}

