package com.flipkart.bean;

/**
 * Represents a time slot in a gym scheduling system.
 * Each slot has a unique identifier, start time, and available seat count.
 */
public class Slots {
	//Unique identifier for each slot
	private int slotsId;

	// Start time of the slot (This might represent an hour of the day, e.g., 14 for 2 PM, but should be clarified)
	private int startTime;

	// Number of seats available in this slot
	private int seatCount;

	/**
	 * Constructor to initialize a Slots object with specified details.
	 * @param slotsId Unique identifier for the slot
	 * @param startTime Start time of the slot
	 * @param seatCount Number of available seats
	 */
	public Slots(int slotsId, int startTime, int seatCount) {
		this.setSlotsId(slotsId);
		this.setStartTime(startTime);
		this.setSeatCount(seatCount);
	}

	/**
	 * Retrieves the slots ID.
	 * This method is used to obtain the unique identifier for a slot, typically representing
	 * a specific time or session in a gym scheduling system.
	 *
	 * @return the slots ID as an integer, uniquely identifying each slot.
	 */
	public int getSlotsId() {
		return slotsId;
	}

	/**
	 * Sets the unique identifier for the slot.
	 * @param slotsId the new ID to assign to the slot
	 */
	public void setSlotsId(int slotsId) {
		this.slotsId = slotsId;
	}

	/**
	 * Retrieves the start time of the slot.
	 * @return the start time as an integer
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Sets the start time for the slot. The time format or system should be specified elsewhere in the documentation.
	 * @param startTime the new start time to assign to the slot
	 */

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	/**
	 * Retrieves the count of available seats in the slot.
	 * @return the seat count as an integer
	 */
	public int getSeatCount() {
		return seatCount;
	}

	/**
	 * Sets the count of available seats for the slot.
	 * @param seatCount the new number of seats to assign
	 */
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
}
