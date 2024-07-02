package com.flipkart.business;

public interface BookingInterface {

	public void addBooking (String userId, String slotId, String gymId);
	public void cancelBooking (String bookingId);
}
