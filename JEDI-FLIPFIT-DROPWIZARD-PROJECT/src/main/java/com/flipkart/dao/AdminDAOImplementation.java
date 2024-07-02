package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the AdminDAOInterface for performing CRUD operations related to gyms, gym owners, and users.
 */
public class AdminDAOImplementation implements AdminDAOInterface {
    JDBCConnection connector;
    Connection conn;

    /**
     * Retrieves a list of all gyms from the database.
     * @return a list of Gym objects
     */
    @Override
    public List<Gym> viewGyms() {
        List<Gym> gyms = new ArrayList<>();
        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VIEW_ALL_GYMS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Gym gym = new Gym();
                gym.setGymId(resultSet.getInt("gymId"));
                gym.setOwnerId(resultSet.getString("ownerId"));
                gym.setGymName(resultSet.getString("gymName"));
                gym.setGymAddress(resultSet.getString("gymAddress"));
                gym.setLocation(resultSet.getString("location"));
                gym.setStatus(resultSet.getString("status"));
                gyms.add(gym);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return gyms;
    }

    /**
     * Retrieves a list of all users from the database.
     * @return a list of User objects
     */
    @Override
    public List<User> viewUsers() {
        List<User> users = new ArrayList<>();
        String sqlQuery = SQLConstants.ADMIN_VIEW_ALL_USERS;

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setuserId(resultSet.getInt("userId"));
                user.setPhoneNumber(resultSet.getString("phoneNumber"));
                user.setUserName(resultSet.getString("userName"));
                user.setAddress(resultSet.getString("Address"));
                user.setLocation(resultSet.getString("location"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching user data: " + e.getMessage());
        }
        return users;
    }

    /**
     * Retrieves a list of all gym owners from the database.
     * @return a list of GymOwner objects
     */
    @Override
    public List<GymOwner> viewGymOwners() {
        List<GymOwner> gymOwners = new ArrayList<>();
        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VIEW_ALL_GYMOWNERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                GymOwner gymOwner = new GymOwner();
                gymOwner.setOwnerId(resultSet.getInt("owner_id"));
                gymOwner.setOwnerName(resultSet.getString("name"));
                gymOwner.setOwnerEmail(resultSet.getString("email"));
                gymOwner.setPhoneNo(resultSet.getString("phone_number"));
                gymOwner.setNationalId(resultSet.getString("aadhar"));
                gymOwner.setGST(resultSet.getString("pancard"));
                gymOwner.setStatus(resultSet.getString("status"));
                gymOwners.add(gymOwner);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return gymOwners;
    }

    /**
     * Retrieves a list of all gym owners from the database.
     * @return a list of GymOwner objects
     */
    @Override
    public boolean verifyGymOwners(int id) {
        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VERIFY_GYMOWNERS)) {
            preparedStatement.setString(1, "verified");
            preparedStatement.setInt(2, id);
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Verifies the status of a gym based on its ID.
     * @param id the ID of the gym to verify
     * @return true if the status was successfully updated to 'verified', false otherwise
     */
    @Override
    public boolean verifyGyms(int id) {
        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQLConstants.ADMIN_VERIFY_GYMS)) {
            preparedStatement.setString(1, "verified");
            preparedStatement.setInt(2, id);
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Retrieves a list of all gyms that are currently marked as unverified.
     * @return a list of unverified Gym objects
     */
    @Override
    public List<Gym> getUnverifiedGyms() {
        conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gym> gyms = new ArrayList<>();

        try {
            String sqlQuery = SQLConstants.ADMIN_VIEW_UNVERIFIED_GYMS;
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, "Inactive");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("gymId");
                String gymAddress = resultSet.getString("gymAddress");
                String location = resultSet.getString("location");
                String gymName = resultSet.getString("gymName");
                String status = resultSet.getString("status");
                String gymOwnerID = resultSet.getString("ownerId");
                Gym gym = new Gym();
                gym.setGymId(id);
                gym.setGymName(gymName);
                gym.setGymAddress(gymAddress);
                gym.setOwnerId(gymOwnerID);
                gym.setLocation(location);
                gym.setStatus(status);
                gyms.add(gym);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return gyms;
    }

    /**
     * Retrieves a list of all gym owners that are currently marked as unverified.
     * @return a list of unverified GymOwner objects
     */
    @Override
    public List<GymOwner> getUnverifiedGymOwner() {
        conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<GymOwner> gymOwners = new ArrayList<>();

        try {
            String sqlQuery = SQLConstants.ADMIN_VIEW_UNVERIFIED_GYMOWNER;
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, "Inactive");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("owner_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String ph = resultSet.getString("phone_number");
                String nationalId = resultSet.getString("aadhar");
                String gst = resultSet.getString("gst");

                GymOwner x = new GymOwner();
                x.setOwnerId(id);
                x.setOwnerName(name);
                x.setOwnerEmail(email);
                x.setPhoneNo(ph);
                x.setNationalId(nationalId);
                x.setGST(gst);

                gymOwners.add(x);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return gymOwners;
    }
}
