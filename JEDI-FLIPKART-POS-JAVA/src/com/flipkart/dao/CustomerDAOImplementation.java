package com.flipkart.dao;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Slots;
import com.flipkart.bean.User;
import com.flipkart.constants.SQLConstants;
import com.flipkart.exception.InvalidCredentialsException;
import com.flipkart.exception.RegistrationFailedException;
import com.flipkart.exception.SlotsUnavailableException;
import com.flipkart.utils.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerDAOImplementation implements CustomerDAOInterface {

    JDBCConnection connector ;
    Connection conn;

    @Override
    public void updateGymUserPassword(String email,String password, String updatedPassword) {
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            statement = conn.createStatement();
            preparedStatement = conn.prepareStatement(SQLConstants.GYM_USER_UPDATE_PASSWORD, statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, updatedPassword);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);


            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Updated Password successfully!");
            } else {
                throw new InvalidCredentialsException();
            }

        }catch(InvalidCredentialsException ex){
            System.out.println("Gym user " + ex.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean verifyGymUserPassword(String email, String password) {
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

    @Override
    public List<Gym> getAllGyms() {
        conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gym> gyms = new ArrayList<>();

        try {
            String sqlQuery = "SELECT * FROM gyms";
            preparedStatement = conn.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("gymId");
                String gymAddress = resultSet.getString("gymAddress");
                String location = resultSet.getString("location");
                String gymName = resultSet.getString("gymName");
                String status = resultSet.getString("status");
                String gymOwnerID = resultSet.getString("ownerid");
                if(Objects.equals(status, "unverified")) continue;
                Gym gym = new Gym();
                gym.setGymName(gymName);
                gym.setGymAddress(gymAddress);
                gym.setOwnerId(gymOwnerID);
                gym.setLocation(location);
                gym.setStatus(status);
                gym.setGymId(id);
                gyms.add(gym);

                List<Slots> slots = getGymSlotsWithGymId(id);
                gym.setSlots(slots);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        System.out.println(gyms.size());
        return gyms;
    }

    public boolean bookSlot(int gymId, int time, String email) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String insertQuery = "INSERT INTO Booking (userId, status, date, time, slotId, GymId) VALUES (?, ?, ?, ?, ?, ?)";

        int alreadyBooked = getSeatNumberWithGymIDandSlotId(gymId, time);
        int remaining = getSeatNumberWithGymIDandSlotIdFromSlots(gymId, time);

        try {
            conn = JDBCConnection.getConnection();

            // Check if slots are available
            if (remaining <= 0) {
                System.out.println("No slots available");
                throw new SlotsUnavailableException();
            }

            preparedStatement = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

            // Set values for the placeholders in the prepared statement
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, "CONFIRMED");
            preparedStatement.setInt(3, 11);
            preparedStatement.setInt(4, time);
            preparedStatement.setInt(5, time); // Assuming slotId is the same as time for demonstration
            preparedStatement.setInt(6, gymId);

            // Execute the insert statement
            int rowsInserted = preparedStatement.executeUpdate();

            // Check if the insert was successful
            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully!");

                // Retrieve the generated keys (bookingId)
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    int bookingId = resultSet.getInt(1);
                    System.out.println("Booking ID: " + bookingId);
                }

                // Update remaining seats in the database
                int updatedRemaining = remaining - 1;
                alterSeatsWithGymIDSlotID(gymId, time, updatedRemaining);
            } else {
                throw new SlotsUnavailableException();
            }

        } catch (SlotsUnavailableException | SQLException ex) {
            System.out.println(ex.getMessage());
            return false; // Return false if an exception occurs
        } finally {
            // Close resources in the finally block to ensure they are always closed
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true; // Return true if booking and seat update were successful
    }


    private int getSeatNumberWithGymIDandSlotIdFromSlots(int gymId, int time) {
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        int x = 0;
        try {
            String sqlQuery = "SELECT seatCount FROM slots WHERE gymId= "  + gymId + " AND startTime = " + time;
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                x = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return x;
    }

    private void alterSeatsWithGymIDSlotID(int gymId, int time,int x) {
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        int resultSet = 0;
        List<Slots> slotList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            String sqlQuery = "UPDATE slots SET seatCount= " + x + "   WHERE gymId= " + gymId + " AND startTime= " + time;
            preparedStatement = conn.prepareStatement(sqlQuery);

            resultSet = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    private int getSeatNumberWithGymIDandSlotId(int gymId, int time) {
        conn = JDBCConnection.getConnection();
        Statement statement=null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        int number=0;
        try {
            String sqlQuery= "SELECT COUNT(*) from Booking where gymId=? AND time=?";
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, gymId);
            preparedStatement.setInt(2, time);

            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                number = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return number;
    }

    @Override
    public List<Bookings> getAllBookingByUserID(String userId) {
        conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Bookings> bookings = new ArrayList<>();

        try {
            String sqlQuery = "SELECT * FROM Booking where userId=\"" + userId + "\"";
            preparedStatement = conn.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("bookingId");
                int date = resultSet.getInt("date");
                int time = resultSet.getInt("time");
                int slotId = resultSet.getInt("slotId");
                String status = resultSet.getString("status");
                int gymId = resultSet.getInt("gymId");
                Bookings booking = new Bookings();
                booking.setBookingId(id);
                booking.setDate(date);
                booking.setTime(time);
                booking.setSlotId(slotId);
                booking.setStatus(status);
                booking.setGymId(gymId);
                bookings.add(booking);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookings;
    }

    //@Override
//    public boolean cancelBooking(int bookingId) {
//        conn = JDBCConnection.getConnection();
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        List<Bookings> bookings = new ArrayList<>();
//
//        try {
//            String sqlQuery = "DELETE * FROM Booking where bookingId=" + bookingId;
//            preparedStatement = conn.prepareStatement(sqlQuery);
//            preparedStatement.executeQuery();
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return true;
//    }

    @Override
    public boolean cancelBooking(int bookingId) {
        conn = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Retrieve the slotId associated with the bookingId
            String getSlotIdQuery = "SELECT slotId FROM Booking WHERE bookingId = ?";
            preparedStatement = conn.prepareStatement(getSlotIdQuery);
            preparedStatement.setInt(1, bookingId);
            resultSet = preparedStatement.executeQuery();

            int slotId = -1;
            if (resultSet.next()) {
                slotId = resultSet.getInt("slotId");
            }

            if (slotId == -1) {
                System.out.println("No booking found with bookingId: " + bookingId);
                return false;
            }

            // Step 2: Delete the booking from the Booking table
            String deleteBookingQuery = "DELETE FROM Booking WHERE bookingId = ?";
            preparedStatement = conn.prepareStatement(deleteBookingQuery);
            preparedStatement.setInt(1, bookingId);
            preparedStatement.executeUpdate();

            // Step 3: Increase the seatCount in the Slots table
            String updateSlotQuery = "UPDATE Slots SET seatCount = seatCount + 1 WHERE slotId = ?";
            preparedStatement = conn.prepareStatement(updateSlotQuery);
            preparedStatement.setInt(1, slotId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return true;
    }


    @Override
    public boolean validateUser(String username, String pass) {
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        String password2 = "-";
        try {
            String sqlQuery = "SELECT * FROM User WHERE email= \""  + username + "\"";
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

    @Override
    public void createUser(User user) {
        conn = JDBCConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String insertQuery = "INSERT INTO User (userName,email, password, phoneNumber, Address, location) VALUES(?,?,?,?,?,?)";

        try {
            statement = conn.createStatement();
//            resultSet = statement.executeQuery(insertQuery);
            preparedStatement =  conn.prepareStatement(insertQuery);

            // 5. Set values for the placeholders in the prepared statement

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getLocation());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                throw new RegistrationFailedException();
            }

        }catch(RegistrationFailedException ex){
            System.out.println("User "+ ex.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Slots> getGymSlotsWithGymId(int id){
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
}
