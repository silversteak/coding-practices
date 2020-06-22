package com.system.design.FlightBooking;

public class Seat {

	private String seatNumber;
	private SeatClass sClass;
	
	public Seat(String seatNumber, SeatClass sClass) {
		super();
		this.seatNumber = seatNumber;
		this.sClass = sClass;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public SeatClass getsClass() {
		return sClass;
	}

	public void setsClass(SeatClass sClass) {
		this.sClass = sClass;
	}

	@Override
	public String toString() {
		return "Seat [seatNumber=" + seatNumber + ", sClass=" + sClass + "]";
	}
	
	
}
