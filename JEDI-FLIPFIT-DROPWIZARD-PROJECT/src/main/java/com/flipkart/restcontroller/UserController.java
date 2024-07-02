package com.flipkart.restcontroller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Handles user-level actions and provides RESTful API endpoints for user interactions.
 * This controller mainly provides guidance for accessing the user menu and logging in
 * as different types of users such as Admin, Customer, or Gym Owner.
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {


    /**
     * Provides the main user menu for the Flipkart system, offering options to register, login,
     * or change password.
     *
     * @return a {@link Response} object containing the main menu as a string.
     */
    @GET
    @Path("/")
    public Response getUserMenu() {

        return Response.ok("Welcome to Flipfit! \n" +
                        "1. Register -> /register\n" +
                        "2. Login -> /login\n" +
                        "3. Change Password -> /change_password")
                .build();

    }

    /**
     * Provides options for logging in to the system, directing users to the appropriate endpoints
     * for logging in as an Admin, Customer, or Gym Owner.
     *
     * @return a {@link Response} object containing login options as a string, with placeholders for credentials.
     */
    @GET
    @Path("/login")
    public Response login() {

        return Response.ok("To Login as - ! \n" +
                        "1. Admin -> /admin/login&username=\"\"&password=\"\"\n" +
                        "2. Customer -> /customer/login&username=\"\"&password=\"\"\n" +
                        "3. GymOwner -> /gymOwner/login&email=\"\"&password=\"\"")
                .build();
    }

}
