package com.flipkart.app;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.flipkart.restcontroller.AdminController;

/**
 * Main application class for the Dropwizard service. This class sets up and runs the service,
 * configuring resources, health checks, and other environment settings.
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    /**
     * Initializes any required bootstrap configurations before the application runs.
     * This method can be used to configure aspects like command line parameters, bundles, assets, etc.
     *
     * @param bootstrap the bootstrap object which allows for adding bundles and configurations.
     */
    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        // Add initialization logic here
    }

    /**
     * Starts the Dropwizard application. This method sets up the RESTful resources and necessary environment settings.
     *
     * @param configuration the configuration object that can be used to retrieve specific configurations.
     * @param environment the environment object that manages the various components of a Dropwizard application.
     * @throws Exception if there is an issue starting up the application.
     */
    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        LOGGER.info("Registering REST resources");

        // Register RESTful resource controllers
        environment.jersey().register(new com.flipkart.restcontroller.UserController());
        environment.jersey().register(new AdminController());
        environment.jersey().register(new com.flipkart.restcontroller.CustomerController());
        environment.jersey().register(new com.flipkart.restcontroller.GymOwnerController());
    }

    /**
     * Main method that serves as the entry point for the application.
     *
     * @param args command line arguments that can be passed to configure the application.
     * @throws Exception if there is an error during application startup.
     */
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
