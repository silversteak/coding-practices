package com.system.design.FlightBooking;

import java.sql.Date;
import java.util.Map;

public class FlightReservation {
	
	private String reservationNumber;
	private FlightSchedule flightSchedule;
	private Map<Customer, FlightSeat> seatMap;
	private Date bookingDate;
	private Date creationDate;
	private BookingStatus status;
	public String getReservationNumber() {
		return reservationNumber;
	}
	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}
	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}
	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}
	public Map<Customer, FlightSeat> getSeatMap() {
		return seatMap;
	}
	public void setSeatMap(Map<Customer, FlightSeat> seatMap) {
		this.seatMap = seatMap;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public BookingStatus getStatus() {
		return status;
	}
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FlightReservation [reservationNumber=" + reservationNumber + ", flightSchedule=" + flightSchedule
				+ ", seatMap=" + seatMap + ", bookingDate=" + bookingDate + ", creationDate=" + creationDate
				+ ", status=" + status + "]";
	}
	
}
