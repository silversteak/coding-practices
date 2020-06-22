package com.system.design.FlightBooking;

import java.util.ArrayList;
import java.util.List;

public class Airport {

	private String name;
	private String address;
	private String code;
	private List<Flight> flights;
	
	public Airport(String name, String address, String code) {
		super();
		this.name = name;
		this.address = address;
		this.code = code;
		this.flights = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	public void addFlight(Flight flight) {
		this.flights.add(flight);
	}
	
	
	
	
	
}
