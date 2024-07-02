package com.flipkart.bean;

import java.util.List;

/**
 * Represents a Gym Owner in the Flipkart system.
 * This class contains the details and operations related to a gym owner including personal, contact, and business information.
 */
public class GymOwner {
	// Unique identifier for each gym owner
	private int ownerId;

	// Email address of the gym owner
	private String ownerEmail;

	// Password for the gym owner's account login
	private String password;

	// Contact phone number of the gym owner
	private String phoneNo;

	// National ID of the gym owner (e.g., Aadhar in India)
	private String nationalId;

	// GST number for tax purposes
	private String GST;

	// List of gyms owned by the owner
	private List<Gym> gyms;

	// PAN number for tax identification
	private String PAN;

	// Full name of the gym owner
	private String ownerName;

	// Operational status of the gym owner (e.g., Active, Suspended)
	private String status;

	// Verification status of the gym owner's account (e.g., Verified, Pending, Unverified)
	private String verificationStatus;

	/**
	 * Gets the unique identifier for the gym owner.
	 * @return the unique identifier as an integer.
	 */
	public int getOwnerId() {
		return ownerId;
	}

	/**
	 * Sets the unique identifier for the gym owner.
	 * @param ownerId the new ID to assign to the gym owner
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * Retrieves the email address of the gym owner.
	 * @return the email address as a String
	 */
	public String getOwnerEmail() {
		return ownerEmail;
	}

	/**
	 * Sets the email address of the gym owner.
	 * @param ownerEmail the new email address to assign
	 */
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	/**
	 * Retrieves the password for the gym owner's account.
	 * @return the account password as a String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password for the gym owner's account.
	 * @param password the new password to assign
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Retrieves the phone number of the gym owner.
	 * @return the phone number as a String
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Sets the phone number for the gym owner.
	 * @param phoneNo the new phone number to assign
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Retrieves the national ID of the gym owner.
	 * @return the national ID as a String
	 */
	public String getNationalId() {
		return nationalId;
	}

	/**
	 * Sets the national ID for the gym owner.
	 * @param nationalId the new national ID to assign
	 */
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	/**
	 * Retrieves the GST number of the gym owner.
	 * @return the GST number as a String
	 */
	public String getGST() {
		return GST;
	}

	/**
	 * Sets the GST number for the gym owner.
	 * @param GST the new GST number to assign
	 */
	public void setGST(String GST) {
		this.GST = GST;
	}

	/**
	 * Retrieves the list of gyms owned by the gym owner.
	 * @return a list of Gym objects
	 */
	public List<Gym> getGyms() {
		return gyms;
	}

	/**
	 * Sets the list of gyms owned by the gym owner.
	 * @param gyms the new list of gyms to be associated with the gym owner.
	 */
	public void setGyms(List<Gym> gyms) {
		this.gyms = gyms;
	}

	/**
	 * Retrieves the list of gyms owned by the gym owner.
	 * @return a list of Gym objects
	 */
	public String getPAN() {
		return PAN;
	}

	/**
	 * Sets the PAN number for the gym owner.
	 * @param PAN the new PAN number to assign.
	 */
	public void setPAN(String PAN) {
		this.PAN = PAN;
	}

	/**
	 * Retrieves the full name of the gym owner.
	 * @return the owner's full name as a String
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * Sets the full name of the gym owner.
	 * @param ownerName the new name to assign
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * Retrieves the operational status of the gym owner.
	 * @return the status as a String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the operational status of the gym owner.
	 * @param status the new status to assign
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Retrieves the verification status of the gym owner's account.
	 * @return the verification status as a String
	 */
	public String getVerificationStatus() {
		return verificationStatus;
	}

	/**
	 * Sets the verification status of the gym owner's account.
	 * @param verificationStatus the new verification status to assign
	 */
	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

}
