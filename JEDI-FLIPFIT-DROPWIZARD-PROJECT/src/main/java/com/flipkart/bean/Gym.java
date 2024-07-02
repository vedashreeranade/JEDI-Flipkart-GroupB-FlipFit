package com.flipkart.bean;

import java.util.List;

/**
 * Represents a Gym entity in the Flipkart system.
 * This class encapsulates details about gyms including their location, owner, and available slots.
 */
public class Gym {
	// Unique identifier for each gym
	private int gymId;

	// Name of the gym
	private String gymName;

	// Physical address of the gym
	private String gymAddress;

	// Geographical location of the gym, could be used for mapping
	private String location;

	// List of available slots in the gym
	private List<Slots> slots;

	// Identifier for the owner of the gym
	private String ownerId;

	// Current operational status of the gym, e.g., Active, Inactive
	private String Status;

	/**
	 * Retrieves the owner's ID of this gym.
	 * @return the owner ID as a String
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * Sets the owner's ID for this gym.
	 * @param ownerId the new owner ID to be set
	 */
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * Gets the current status of the gym.
	 * @return the status of the gym
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * Sets the status of the gym.
	 * @param status the new status to be set for the gym
	 */
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * Retrieves the list of available slots at the gym.
	 * @return a list of Slots objects
	 */
	public List<Slots> getSlots() {
		return slots;
	}

	/**
	 * Sets the list of available slots for the gym.
	 * @param slots the new list of Slots to be set
	 */
	public void setSlots(List<Slots> slots) {
		this.slots = slots;
	}

	/**
	 * Retrieves the gym's unique ID.
	 * @return the gym ID as an integer
	 */
	public int getGymId() {
		return gymId;
	}

	/**
	 * Sets the gym ID. This should be unique for each gym.
	 * @param gymId the new gym ID to be set
	 */
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}

	/**
	 * Gets the name of the gym.
	 * @return the name of the gym
	 */
	public String getGymName() {
		return gymName;
	}

	/**
	 * Sets the name of the gym.
	 * @param gymName the new name to be set for the gym
	 */
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}

	/**
	 * Retrieves the address of the gym.
	 * @return the physical address of the gym
	 */
	public String getGymAddress() {
		return gymAddress;
	}

	/**
	 * Sets the physical address of the gym.
	 * @param gymAddress the new address to be set
	 */
	public void setGymAddress(String gymAddress) {
		this.gymAddress = gymAddress;
	}

	/**
	 * Gets the geographical location of the gym.
	 * @return the location as a String
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the geographical location of the gym.
	 * @param location the new location to be set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
