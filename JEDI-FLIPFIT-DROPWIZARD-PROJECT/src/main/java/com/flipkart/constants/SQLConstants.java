package com.flipkart.constants;

/**
 * Contains SQL query constants for various operations related to gym management in the Flipkart system.
 * This includes operations for gym owners, gym users, and admins.
 */
public class SQLConstants {

    /** Inserts a new gym with complete details into the database. */
    public static final String GYM_OWNER_INSERT_GYM = "INSERT INTO gyms (gymAddress, location, gymName, status, ownerId) VALUES(?,?,?,?,?)";

    /** Retrieves all gym details for a specific owner. Likely intended to be a SELECT query instead of INSERT. */
    public static final String GYM_OWNER_VIEW_GYM = "INSERT INTO gyms (gymAddress, location, gymName, status, ownerId) VALUES(?,?,?,?,?)";

    /** Updates the password for a gym user identified by email. */
    public static final String GYM_USER_UPDATE_PASSWORD = "UPDATE User SET password = ? WHERE email = ? AND Password = ?";

    /** Updates the password for a gym owner identified by email. */
    public static final String GYM_OWNER_UPDATE_PASSWORD = "UPDATE gym_owner SET password = ? WHERE email = ? AND password = ?";

    /** Verifies the password of a gym owner, ensuring the query points to the correct user type. */
    public static final String GYM_USER_VERIFY_PASSWORD = "SELECT * FROM gym_owner WHERE email = ? AND Password = ?";

    /** Verifies the password of a gym owner using their email. */
    public static final String GYM_OWNER_VERIFY_PASSWORD = "SELECT * FROM gym_owner WHERE email = ? AND Password = ?";

    /** Retrieves all users from the database. */
    public static final String ADMIN_VIEW_ALL_USERS = "SELECT * FROM User";

    /** Retrieves all gyms from the database. */
    public static final String ADMIN_VIEW_ALL_GYMS = "SELECT * FROM gyms";

    /** Retrieves all gym owners from the database. */
    public static final String ADMIN_VIEW_ALL_GYMOWNERS = "SELECT * FROM gym_owner";

    /** Updates the verification status of gyms based on gym ID. */
    public static final String ADMIN_VERIFY_GYMS = "UPDATE gyms SET status = ? WHERE gymId = ?";

    /** Updates the verification status of gym owners based on owner ID. */
    public static final String ADMIN_VERIFY_GYMOWNERS = "UPDATE gym_owner SET status = ? WHERE owner_id = ?";

    /** Retrieves all unverified gyms based on their status. */
    public static final String ADMIN_VIEW_UNVERIFIED_GYMS = "SELECT * FROM gyms WHERE status=?";

    /** Retrieves all unverified gym owners based on their status. */
    public static final String ADMIN_VIEW_UNVERIFIED_GYMOWNER = "SELECT * FROM gym_owner WHERE status=?";

    /** Inserts a new gym owner with comprehensive details into the database. */
    public static final String GYM_OWNER_INSERT = "INSERT INTO gym_owner (email, name, password, phone_number, pancard, aadhar, gst, status) VALUES(?,?,?,?,?,?,?,?)";
}
