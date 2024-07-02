package com.flipkart.restcontroller;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.business.AdminService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * AdminController provides RESTful web services for administrative operations.
 */
@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminController {

    private AdminService adminService;
    /**
     * Constructs an AdminController with a new instance of AdminService.
     */
    public AdminController() {
        this.adminService = new AdminService(); // Initialize the AdminService
    }

    /**
     * Provides the endpoint for administrator login using username and password.
     * @param user_name The username of the administrator trying to log in.
     * @param password The password of the administrator.
     * @return A Response indicating the outcome of the login attempt.
     */
    @GET
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(@QueryParam("username") String user_name, @QueryParam("password") String password) {
        System.out.println("Hello there!");
        if (true) {
            return Response.ok().entity("Login successful").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
        }
    }

    /**
     * Retrieves a list of all gym owners registered in the system.
     * @return A response object containing the list of gym owners.
     */
    @GET
    @Path("/viewGymOwners")
    public Response viewGymOwners() {
        List<GymOwner> gymOwners = adminService.viewGymOwners();
        return Response.ok(gymOwners).build();
    }

    /**
     * Retrieves a list of all gyms registered in the system.
     * @return A response object containing the list of gyms.
     */
    @GET
    @Path("/viewGyms")
    public Response viewGyms() {
        List<Gym> allgyms = adminService.viewGyms();
        return Response.ok(allgyms).build();
    }

    /**
     * Fetches and displays a list of all users.
     * @return A Response containing a list of users.
     */
    @GET
    @Path("/viewUsers")
    public Response viewUsers() {
        List<User> alluser = adminService.viewUsers();
        return Response.ok(alluser).build();
    }

    /**
     * Verifies a specific gym based on the provided gym ID.
     * @param id The ID of the gym to be verified.
     * @return A Response indicating whether the verification was successful.
     */
    @PUT
    @Path("/verifyGym/{id}")
    public Response verifyGym(@PathParam("id") Integer id) {
        adminService.verifyGym(id);
        return Response.ok("Gym verified successfully.").build();
    }

    /**
     * Verifies a gym owner based on the provided owner ID.
     * @param id The ID of the gym owner to be verified.
     * @return A Response indicating whether the verification was successful.
     */
    @PUT
    @Path("/verifyGymOwner/{id}")
    public Response verifyGymOwner(@PathParam("id") Integer id) {
        adminService.verifyGymOwner(id);
        return Response.ok("Gym owner verified successfully.").build();
    }

    /**
     * Retrieves a list of all unverified gym owners.
     * @return A Response containing a list of unverified gym owners.
     */
    @GET
    @Path("/getUnverifiedGymOwners")
    public Response getUnverifiedGymOwners() {
        List<GymOwner> unverifiedOwners = adminService.getUnverifiedGymOwners();
        return Response.ok(unverifiedOwners).build();
    }

    /**
     * Retrieves a list of all unverified gyms.
     * @return A Response containing a list of unverified gyms.
     */
    @GET
    @Path("/getUnverifiedGyms")
    public Response getUnverifiedGyms() {
        List<Gym> unverifiedGyms = adminService.getUnverifiedGyms();
        return Response.ok(unverifiedGyms).build();
    }
}
