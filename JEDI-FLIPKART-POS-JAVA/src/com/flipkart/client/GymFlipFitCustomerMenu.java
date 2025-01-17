package com.flipkart.client;
import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.business.CustomerService;

import java.util.Scanner;
public class GymFlipFitCustomerMenu {
    static Scanner obj = new Scanner(System.in);
    CustomerService userServiceOperation = new CustomerService();
    User user = new User();
    public boolean userLogin(String username, String pass) {
        if (validateUser(username, pass)) {
            boolean flag = true;
            System.out.println("Login Successful");
            while (flag) {
                System.out.println("\n------------------CUSTOMER MENU-----------------\n");

                System.out.println("1. View all Gyms with slots");
                System.out.println("2. Book Slot");
                System.out.println("3. Cancel Slot");
                System.out.println("4. View all Bookings");
                System.out.println("5. View all Gyms by Area");
                System.out.println("6. Logout");

                int choice = Integer.parseInt(obj.nextLine());
                switch (choice) {
                    case 1:
                        List<Gym> gyms = viewAllGymswithSlots();
                        printGyms(gyms);
                        break;
                    case 2:
                        List<Gym> gyms1 = viewAllGymswithSlots();
                        printGyms(gyms1);
                        System.out.println("Enter the following:");
                        System.out.println("Gym ID");
                        int gymId = Integer.parseInt(obj.nextLine());
                        System.out.println("Slot Time");
                        int time = Integer.parseInt(obj.nextLine());

                        if (bookSlot(gymId, time, username)) {
                            System.out.println("\nBooked Successfully\n");
                        } else {
                            System.out.println("\nBooking Unsuccessful\n");
                        }
                        break;
                    case 3:
                        Scanner sc = new Scanner(System.in);
                        System.out.println("My Bookings");
                        System.out.println(viewAllBookings(username));
                        System.out.println("Enter Booking ID");
                        int bookingId = sc.nextInt();
                        cancelSlot(bookingId);
                        break;
                    case 4:
                        System.out.println("My Bookings");
                        List<Bookings> bookings = viewAllBookings(username);
                        for (Bookings booking : bookings) {
                            System.out.println("Booking ID: " + booking.getBookingId() + "\nBooking Status: " + booking.getStatus() + " \nTime: " + booking.getTime() + "\nGymID: " + booking.getGymId());
                        }
                        break;
                    case 5:
                        System.out.println("Enter location");
                        String location = obj.nextLine();
                        List<Gym> gyms2 = viewAllGymsByArea(location);
                        printGyms(gyms2);
                        break;
                    case 6:
                        System.exit(0);
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }

        } else return false;
        return true;
    }

    private void printGyms(List<Gym> y) {
        for (Gym gym : y) {
            System.out.println();
            System.out.println("Gym name: " + gym.getGymName() +
                    "\nGym ID: " + gym.getGymId() +
                    "\nGym Location: " + gym.getLocation() +
                    "\nGym Address: " + gym.getGymAddress() +
                    "\nSlot List:");

            for (Slots slot : gym.getSlots()) {
                String startTime = String.format("%02d:00", slot.getStartTime());
                String endTime = String.format("%02d:00", (slot.getStartTime() + 1));
                System.out.println("Start Time: " + startTime + " | End Time: " + endTime + " | Remaining Seats: " + slot.getSeatCount());
            }

        }
    }

    public boolean validateUser(String username, String pass) {
        return userServiceOperation.validateUser(username, pass);
    }

    List<Gym> viewAllGymswithSlots() {
        System.out.println("List of Gyms");
        List<Gym> gymList = userServiceOperation.getAllGymsWithSlots();
        return gymList;
    }

    public boolean bookSlot(int gymId, int time, String email) {
        return userServiceOperation.bookSlots(gymId, time, email);
    }
    public void cancelSlot(int bookingId) {
        System.out.println("\nSlot Cancelled\n");
        userServiceOperation.cancelSlots(bookingId);
    }

    public List<Bookings> viewAllBookings(String userid) {
        List<Bookings> myBookings = userServiceOperation.getAllBookings(userid);
        return myBookings;
    }



    List<Gym> viewAllGymsByArea(String location) {
        System.out.println("List of Gyms");
        List<Gym> gymList = userServiceOperation.getAllGymsByArea(location);
        return gymList;
    }


    public void createCustomer() {
        System.out.println("Enter the following info:");
        System.out.println("\nYour email: ");
        String ownerEmail = obj.nextLine();
        System.out.println("\nYour name: ");
        String ownerName = obj.nextLine();
        System.out.println("\nEnter a password: ");
        String password = obj.nextLine();
        System.out.println("\nPhone number: ");
        String phoneNo = obj.nextLine();
        System.out.println("\nEnter Address ");
        String nationalId = obj.nextLine();
        System.out.println("\nLocation: ");
        String GST = obj.nextLine();

        User user = new User();
        user.setEmail(ownerEmail);
        user.setAddress(nationalId);
        user.setLocation(GST);
        user.setPassword(password);
        user.setUserName(ownerName);
        user.setPhoneNumber(phoneNo);

        userServiceOperation.createUser(user);
    }
}
