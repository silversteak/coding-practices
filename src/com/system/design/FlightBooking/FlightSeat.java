package com.system.design.FlightBooking;

public class FlightSeat extends Seat {
	private double fare;
	private BookingStatus status;
	
	public FlightSeat(String seatNumber, SeatClass sClass, double fare, BookingStatus status) {
		super(seatNumber, sClass);
		this.fare = fare;
		this.status = status;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FlightSeat [fare=" + fare + ", status=" + status + "]";
	}

	
}
