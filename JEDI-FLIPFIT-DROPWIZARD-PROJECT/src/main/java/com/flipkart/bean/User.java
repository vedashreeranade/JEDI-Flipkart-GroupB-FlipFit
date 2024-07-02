package com.flipkart.bean;

/**
 * Represents a User in the Flipkart system.
 * This class encapsulates the basic information of a user, including contact details and credentials.
 */
public class User {
	// Unique identifier for each user
	private int userId;

	// User's name
	private String userName;

	// User's phone number
	private String phoneNumber;

	// Physical address of the user
	private String address;

	// Geographical location of the user, could be used for delivery purposes
	private String location;

	// User's email address for contact and login purposes
	private String email;

	// User's password for account security
	private String password;

	/**
	 * Retrieves the user ID.
	 * This method is typically used to uniquely identify the user within the system.
	 *
	 * @return the user ID as an integer.
	 */
	public int getuserId() {
		return userId;
	}

	/**
	 * Sets the unique identifier for the user.
	 * @param userId the new ID to assign to the user
	 */
	public void setuserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Retrieves the name of the user.
	 * @return the user's name as a String
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the name of the user.
	 * @param userName the new name to assign to the user
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Retrieves the email address of the user.
	 * @return the user's email as a String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the user.
	 * @param email the new email to assign to the user
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieves the phone number of the user.
	 * @return the user's phone number as a String
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number of the user.
	 * @param phoneNumber the new phone number to assign
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Retrieves the physical address of the user.
	 * @return the user's address as a String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the physical address of the user.
	 * @param address the new address to assign
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Retrieves the geographical location of the user.
	 * @return the location as a String
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the geographical location of the user.
	 * @param location the new location to assign
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Retrieves the password of the user.
	 * @return the user's password as a String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user, enhancing account security.
	 * @param password the new password to assign
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
