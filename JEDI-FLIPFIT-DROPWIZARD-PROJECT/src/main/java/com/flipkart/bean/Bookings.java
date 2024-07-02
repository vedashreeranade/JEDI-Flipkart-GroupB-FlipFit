package com.flipkart.bean;

/**
 * Represents a booking in the Flipkart system for gym slots.
 * This class encapsulates all the details of a booking including the user's details,
 * the timing of the booking, and the booking's current status.
 */
public class Bookings {

	private int bookingId;       // Unique identifier for each booking
	private int userId;          // User identifier who made the booking
	private int createdAt;       // Timestamp for when the booking was created
	private int bookingStatus;   // Numeric status of the booking (e.g., confirmed, cancelled)
	private int date;            // Date of the booking, typically represented as YYYYMMDD
	private int time;            // Time of the booking, typically represented in HHMM format
	private int slotId;          // Identifier for the booked slot
	private int gymId;           // Identifier for the gym associated with the booking
	private String status;       // Description of the current status of the booking (e.g., "Confirmed", "Cancelled")

	/**
	 * Gets the date of the booking.
	 * @return The date of the booking as an integer (YYYYMMDD).
	 */
	public int getDate() {
		return date;
	}

	/**
	 * Sets the date for the booking.
	 * @param date The new date of the booking in YYYYMMDD format.
	 */
	public void setDate(int date) {
		this.date = date;
	}

	/**
	 * Gets the slot ID associated with the booking.
	 * @return The slot ID as an integer.
	 */
	public int getSlotId() {
		return slotId;
	}

	/**
	 * Sets the slot ID for the booking.
	 * @param slotId The new slot ID to be used for the booking.
	 */
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	/**
	 * Gets the gym ID associated with the booking.
	 * @return The gym ID as an integer.
	 */
	public int getGymId() {
		return gymId;
	}

	/**
	 * Sets the gym ID for the booking.
	 * @param gymId The new gym ID to be set for the booking.
	 */
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}

	/**
	 * Gets the current status of the booking.
	 * @return The status of the booking as a string.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the current status of the booking.
	 * @param status The new status (e.g., "Confirmed", "Cancelled") of the booking.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the time of the booking.
	 * @return The time of the booking as an integer (HHMM).
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Sets the time for the booking.
	 * @param time The new time of the booking in HHMM format.
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * Gets the booking ID.
	 * @return The booking ID as an integer.
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * Sets the booking ID.
	 * @param bookingId The new booking ID to be set.
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * Gets the user ID of the individual who made the booking.
	 * @return The user ID as an integer.
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the user ID for the booking.
	 * @param userId The new user ID to be associated with the booking.
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets the timestamp of when the booking was created.
	 * @return The creation timestamp as an integer.
	 */
	public int getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the timestamp for when the booking was created.
	 * @param createdAt The new creation timestamp.
	 */
	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets the numeric status of the booking.
	 * @return The booking status as an integer.
	 */
	public int getBookingStatus() {
		return bookingStatus;
	}

	/**
	 * Sets the numeric status of the booking.
	 * @param bookingStatus The new status code for the booking.
	 */
	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
}
