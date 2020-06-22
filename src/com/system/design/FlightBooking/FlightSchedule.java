package com.system.design.FlightBooking;

import java.util.Date;
import java.util.List;

public class FlightSchedule {
	
	private Flight flight;
	private Date departureTime;
	private String gate;
	private FlightStatus status;
	private List <FlightSeat> fSeats;
	private int availableSeats;
	public FlightSchedule(Flight flight, Date departureTime, String gate, FlightStatus status,
			List<FlightSeat> fSeats) {
		super();
		this.flight = flight;
		this.departureTime = departureTime;
		this.gate = gate;
		this.status = status;
		this.fSeats = fSeats;
		this.availableSeats = fSeats.size();
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public FlightStatus getStatus() {
		return status;
	}

	public void setStatus(FlightStatus status) {
		this.status = status;
	}

	public List<FlightSeat> getfSeats() {
		return fSeats;
	}

	public void setfSeats(List<FlightSeat> fSeats) {
		this.fSeats = fSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public String toString() {
		return "FlightSchedule [flight=" + flight + ", departureTime=" + departureTime + ", gate=" + gate + ", status="
				+ status + ", fSeats=" + fSeats + "]";
	}
	

}
