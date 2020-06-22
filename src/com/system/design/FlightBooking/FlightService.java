package com.system.design.FlightBooking;

import java.util.List;

public class FlightService {

	private static FlightService flightService;
	
	private FlightService() {};
	
	public static FlightService getInstance() {
		if (flightService == null) {
			flightService = new FlightService();
		}
		return flightService;
	}
	
	private FlightUserDAO flightUserDAO = FlightUserDAO.getInstance();
	
	public List<FlightSchedule> searchFlights(String from) throws EmptyFlightException{
		return flightUserDAO.searchFlights(from);
	}
	
	public double bookSeats(FlightSchedule flightSchedule, int number) throws UnavailibilityException{
		return flightUserDAO.bookSeats(flightSchedule, number);
	}
	
}
