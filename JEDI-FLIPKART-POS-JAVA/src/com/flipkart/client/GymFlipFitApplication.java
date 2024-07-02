package com.flipkart.client;

import com.flipkart.business.GymOwnerService;
import com.flipkart.business.CustomerService;
import com.flipkart.business.CustomerInterface;

import java.util.Random;
import java.util.Scanner;
public class GymFlipFitApplication {
    static GymFlipFitGymOwnerMenu owner = new GymFlipFitGymOwnerMenu();
    static GymFlipFitCustomerMenu customer = new GymFlipFitCustomerMenu();
    static GymOwnerService gymOwnerService = new GymOwnerService();

    static CustomerInterface userService = new CustomerService();
    static Scanner obj = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n");
        System.out.println("Welcome to FlipFit!");
        System.out.println("\n");
        boolean exitFlag = false;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Login");
            System.out.println("2. Registration");
            System.out.println("3. Update Password");
            System.out.println("4. Exit");
            int x = scanner.nextInt();
            switch (x) {
                case 1 :
                    System.out.println("Enter role \n1. Admin\n2. Customer\n3. Gym Owner\n");
                    int role = scanner.nextInt();
                    System.out.println("Enter email");
                    String userId = obj.nextLine();
                    System.out.println("Enter password");
                    String password = obj.nextLine();

                    switch (role) {
                        case 1 :
                            GymFlipFitAdminMenu admin = new GymFlipFitAdminMenu();

                            if(!admin.verifyAdminCredentials(userId,password)){
                                System.out.println("\nInvalid Credentials\n");
                                break;
                            }

                            boolean flag = true;

                            while(flag) {

                                System.out.println("Select an option:");
                                System.out.println("1. View all users");
                                System.out.println("2. View all gyms");
                                System.out.println("3. View all gym owners");
                                System.out.println("4. Verify gym");
                                System.out.println("5. Verify gym owner");
                                System.out.println("6. View pending gym owners");
                                System.out.println("7. Exit");


                                int k = Integer.parseInt(obj.nextLine());

                                switch (k) {
                                    case 1:
                                        admin.viewUsers();
                                        break;
                                    case 2:
                                        admin.viewGyms();
                                        break;
                                    case 3:
                                        admin.viewGymOwners();
                                        break;
                                    case 4:
                                        System.out.println("Enter the Gym Id to be verified ");
                                        int id1 = Integer.parseInt(obj.nextLine());
                                        admin.verifyGym(id1);
                                        break;
                                    case 5:
                                        System.out.println("Enter the Gym Owner Id to be verified ");
                                        int id2 = Integer.parseInt(obj.nextLine());
                                        admin.verifyGymOwner(id2);
                                        break;
//                                    case 6:
//                                        admin.viewUnverifiedGyms();
                                        //break;
                                    case 6:
                                        admin.viewUnverifiedGymOwners();
                                        break;
                                    case 7:
                                        System.exit(0);
                                        flag = false;
                                        break;
                                }
                                if(!flag) break;
                            }
                            break;

                        case 2 :
                            if(!customer.userLogin(userId,password))
                                System.out.println("\nInvalid Credentials\n");
                            break;
                        case 3 :
                            if(!owner.gymOwnerLogin(userId,password)){
                                System.out.println("\nInvalid Credentials\n");
                            }

                            break;
                        case 4 :
                            break;
                        default:
                            System.out.println("\nInvalid Options Selected. Please Try Again:(\n");
                            break;

                    }

                    break;
                case 2 :
                    System.out.println("1. Register as a Customer");
                    System.out.println("2. Register as a Gym Owner");
                    System.out.println("3. Go Back");
                    int k = Integer.parseInt(obj.nextLine());
                    switch(k){
                        case 1:
                            customer.createCustomer();
                            break;
                        case 2:
                            owner.createGymOwner();
                        default:
                            break;
                    }
                    break;
                case 3 :
                    System.out.println("----------------------Password Change-----------------\n");
                    System.out.println("Enter email");
                    String user = obj.nextLine();
                    System.out.println("Enter password");
                    String userPassword = obj.nextLine();
                    System.out.println("Enter role \n1. Admin\n2. Customer\n3. Gym Owner\n");
                    int respectiveRole = obj.nextInt();
                    obj.nextLine();
                    System.out.println("Enter New password");
                    String updatedPassword = obj.nextLine();

                    switch (respectiveRole) {
                        case 2 :
                            if(!customer.validateUser(user,userPassword))
                                System.out.println("\nInvalid Credentials\n");
                            else{
                                userService.updateGymUserPassword(user,userPassword, updatedPassword);
                            }
                            break;
                        case 3 :
                            if(!owner.verifyGymOwner(user,userPassword)){
                                System.out.println("\nInvalid Credentials\n");
                            }
                            else{
                                gymOwnerService.updateGymOwnerPassword(user,userPassword, updatedPassword);
                            }

                            break;
                    }
                    break;
                case 4 :
                    exitFlag = true;
                    System.out.println("Thank you for using FlipFit <3");
                    break;
                default:
                    System.out.println("\nInvalid Options Selected. Please Try Again:( \n");
                    break;
                }
            if(exitFlag)break;
        }


    }
}

