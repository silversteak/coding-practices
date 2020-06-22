package com.system.design.FlightBooking;

import java.util.List;

public class Flight {

	private String flightNumber;
	private int duration;
	private Airport departure;
	private Airport arrival;
	private List<Seat> seats;
	private Airline airline;
	
	public Flight(String flightNumber, int duration, Airport departure, Airport arrival) {
		super();
		this.flightNumber = flightNumber;
		this.duration = duration;
		this.departure = departure;
		this.arrival = arrival;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Airport getDeparture() {
		return departure;
	}
	public void setDeparture(Airport departure) {
		this.departure = departure;
	}
	public Airport getArrival() {
		return arrival;
	}
	public void setArrival(Airport arrival) {
		this.arrival = arrival;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", duration=" + duration + ", departure=" + departure
				+ ", arrival=" + arrival + ", seats=" + seats + "]";
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
}
