package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.constants.SQLConstants;
import com.flipkart.exception.InvalidCredentialsException;
import com.flipkart.exception.RegistrationFailedException;
import com.flipkart.exception.SlotInsertionFailedException;
import com.flipkart.utils.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of GymOwnerDaoInterface to manage gym owner related operations in the database.
 */
public class GymOwnerDAOImplementation implements GymOwnerDaoInterface {
    Connection conn;

    JDBCConnection connector;

    /**
     * Updates the password of a gym owner in the database.
     * @param email Email of the gym owner whose password is being updated.
     * @param password Current password for validation.
     * @param updatedPassword New password to set.
     */
    @Override
    public void updateGymOwnerPassword(String email,String password, String updatedPassword) {
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            statement = conn.createStatement();
            preparedStatement = conn.prepareStatement(SQLConstants.GYM_OWNER_UPDATE_PASSWORD, statement.RETURN_GENERATED_KEYS);

            // 5. Set values for the placeholders in the prepared statement

            preparedStatement.setString(1, updatedPassword);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);


            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Updated Password successfully!");
            } else {
                throw new InvalidCredentialsException();
//                System.out.println("Failed to Update  the record.");
//                return;
            }

        }catch(InvalidCredentialsException ex){
            System.out.println("Gym Owner" + ex.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }

    }

    /**
     * Verifies the password of a gym owner.
     * @param email Email of the gym owner.
     * @param password Password to verify.
     * @return true if the password is correct, otherwise false.
     */
    @Override
    public boolean verifyGymOwnerPassword(String email, String password) {
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            statement = conn.createStatement();
            preparedStatement = conn.prepareStatement(SQLConstants.GYM_OWNER_VERIFY_PASSWORD, statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                if(result.getString("status").equals("Unverified")){
                    System.out.println("Unverified User, please contact admin to verify");
                    return false;
                }
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Inserts a new gym into the database.
     * @param gym Gym object containing gym details to insert.
     */
    @Override
    public void addGym(Gym gym){
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        int id = 0;
        try {
            statement = conn.createStatement();
            preparedStatement =  conn.prepareStatement(SQLConstants.GYM_OWNER_INSERT_GYM, statement.RETURN_GENERATED_KEYS);


            preparedStatement.setString(1, gym.getGymAddress());
            preparedStatement.setString(2, gym.getLocation());
            preparedStatement.setString(3, gym.getGymName());
            preparedStatement.setString(4, gym.getStatus());
            preparedStatement.setString(5, gym.getOwnerId());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                throw new RegistrationFailedException();
////                System.out.println("Failed to insert the record.");
//                return ;
            }
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }


        } catch (RegistrationFailedException ex){
            System.out.println("Gym "+ex.getMessage());

        }
        catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        insertSlots(gym.getSlots(),id);

    }

    /**
     * Registers a new gym owner in the database.
     * @param gymOwner GymOwner object containing gym owner details.
     */
    @Override
    public void newGymOwner(GymOwner gymOwner) {
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        conn = JDBCConnection.getConnection();


        try {
            statement = conn.createStatement();
//            resultSet = statement.executeQuery(insertQuery);
            preparedStatement =  conn.prepareStatement(SQLConstants.GYM_OWNER_INSERT);

            // 5. Set values for the placeholders in the prepared statement

            preparedStatement.setString(1, gymOwner.getOwnerEmail());
            preparedStatement.setString(2, gymOwner.getOwnerName());
            preparedStatement.setString(3, gymOwner.getPassword());
            preparedStatement.setString(4, gymOwner.getPhoneNo());
            preparedStatement.setString(5, gymOwner.getPAN());
            preparedStatement.setString(6, gymOwner.getGST());
            preparedStatement.setString(7,gymOwner.getNationalId());
            preparedStatement.setString(8, gymOwner.getStatus());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                throw new RegistrationFailedException();
//                System.out.println("Failed to insert the record.");
//                return ;
            }

        }catch(RegistrationFailedException ex){
            System.out.println("Gym Owner" + ex.getMessage());
        }catch (SQLException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }

    /**
     * Validates the login credentials of a gym owner by checking them against the database.
     * @param email The email address of the gym owner trying to log in.
     * @param password The password provided by the gym owner for login.
     * @return true if the credentials match a record in the database, false otherwise.
     */
    @Override
    public boolean validateLogin(String email, String password) {
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            statement = conn.createStatement();
            preparedStatement = conn.prepareStatement(SQLConstants.GYM_USER_VERIFY_PASSWORD, statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);


            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
        }

        return false;
    }

    /**
     * Inserts multiple slots associated with a specific gym into the database.
     * @param slots List of Slots objects to insert.
     * @param gymId ID of the gym these slots are associated with.
     */
    @Override
    public void insertSlots(List<Slots> slots, int gymId){
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        for( Slots slot: slots){
            String insertQuery = "INSERT INTO slots (startTime, seatCount, gymId) VALUES (?, ?, ?)";

            try {
                statement = conn.createStatement();
                preparedStatement =  conn.prepareStatement(insertQuery);
                preparedStatement.setInt(1, slot.getStartTime());
                preparedStatement.setInt(2, slot.getSeatCount());
                preparedStatement.setInt(3, gymId);

                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Slot record inserted successfully!");
                } else {
                    throw new SlotInsertionFailedException();
                }

            }catch(SlotInsertionFailedException | SQLException ex){
                System.out.println(ex.getMessage());
            }
        }


    }

    /**
     * Retrieves all gyms along with their slots owned by a specific gym owner.
     * @param gymOwnerID ID of the gym owner.
     * @return List of gyms owned by the gym owner.
     */
    @Override
    public List<Gym> viewGymSlots(String gymOwnerID) {
        conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gym> gyms = new ArrayList<>();

        System.out.println("gymowner id in viewGymSlots in dao impl ->" + gymOwnerID);

        try {
            String sqlQuery = "SELECT * FROM gyms WHERE ownerId=?";
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, gymOwnerID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("gymId");
                String gymAddress = resultSet.getString("gymAddress");
                String location = resultSet.getString("location");
                String gymName = resultSet.getString("gymName");
                String status = resultSet.getString("status");
                Gym gym = new Gym();
                gym.setGymName(gymName);
                gym.setGymAddress(gymAddress);
                gym.setOwnerId(gymOwnerID);
                gym.setLocation(location);
                gym.setStatus(status);
                gym.setGymId(id);

                System.out.println("Gym created without slots");

                List<Slots> slots = getGymSlotsWithGymId(id);
                gym.setSlots(slots);

                gyms.add(gym);

                System.out.println("Gym created with slots");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return gyms;
    }

    /**
     * Retrieves all gyms owned by a specific gym owner.
     * @param gymOwnerID ID of the gym owner.
     * @return List of gyms owned by the gym owner.
     */
    @Override
    public List<Gym> viewAllGyms(String gymOwnerID){
        System.out.println("Here in viewAllGyms in GymOwnerDAOImplementation\nownerId is -> " + gymOwnerID);
        conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gym> gyms = new ArrayList<>();

        try {
            String sqlQuery = "SELECT * FROM gyms WHERE ownerId=?";
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, gymOwnerID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("gymId");
                String gymAddress = resultSet.getString("gymAddress");
                String location = resultSet.getString("location");
                String gymName = resultSet.getString("gymName");
                String status = resultSet.getString("status");
                Gym gym = new Gym();
                gym.setGymId(id);
                gym.setGymName(gymName);
                gym.setGymAddress(gymAddress);
                gym.setOwnerId(gymOwnerID);
                gym.setLocation(location);
                gym.setStatus(status);
                gyms.add(gym);

//                List<Slots> slots = getGymSlotsWithGymId(id);
//                gym.setSlots(slots);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return gyms;
    }

    /**
     * Deletes a gym based on the provided gym ID.
     * @param gymId The ID of the gym to be deleted.
     * @return true if the gym was successfully deleted, false otherwise.
     */
    @Override
    public boolean deleteGymByID(int gymId){
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
//        List<Slots> slotList = new ArrayList<>();
        try {
            System.out.println(gymId);
            String sqlQuery = "DELETE FROM gyms WHERE gymId= " + gymId;
            statement = conn.createStatement();
//            resultSet = statement.executeQuery(sqlQuery);

            int rowsAffected = statement.executeUpdate(sqlQuery);
            if (rowsAffected >= 0) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Retrieves all slots for a specific gym ID.
     * @param id Gym ID for which to retrieve slots.
     * @return List of Slots for the gym.
     */
    public List<Slots> getGymSlotsWithGymId(int id){

        System.out.println("gym id in -> getGymSlotsWithGymId in dao impl" + id);

        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List<Slots> slotList = new ArrayList<>();
        try {
            String sqlQuery = "SELECT * FROM slots WHERE gymId= " + id;
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {

                int startTime = resultSet.getInt("startTime");
                int seats = resultSet.getInt("seatCount");
                Slots slots = new Slots(1,startTime,seats);

                slotList.add(slots);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return slotList;
    }

    /**
     * Validates the login credentials of a gym owner by checking them against the database.
     * @param email The email address of the gym owner trying to log in.
     * @param pass The password provided by the gym owner for login.
     * @return true if the credentials match a record in the database, false otherwise.
     */
    @Override
    public boolean validateGymOwner(String email, String pass) {
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        String password2 = "-";
        try {
            String sqlQuery = "SELECT * FROM gym_owner WHERE email= \""  + email + "\"";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                password2 = resultSet.getString("password");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return password2.equals(pass);
    }
}
