package com.flipkart.bean;

/**
 * Represents an Admin entity for the Flipkart system.
 * This class provides the basic attributes and methods to manage an admin's credentials.
 */
public class Admin {
	// Unique identifier for each admin
	private int adminId;

	// Password for admin authentication
	private String password;

	/**
	 * Retrieves the admin's password.
	 * @return the current password of this admin
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets or updates the admin's password.
	 * @param password the new password to be set for this admin
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
