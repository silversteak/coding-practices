package com.system.design.FlightBooking;

import java.util.List;

public class Airline {

	private String name;
	private String code;
	private List<Flight> flights;
	
	public Airline(String name, String code, List<Flight> flights) {
		super();
		this.name = name;
		this.code = code;
		this.flights = flights;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Airline [name=" + name + ", code=" + code + ", flights=" + flights + "]";
	}	
	
}
