package com.system.design.FlightBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightUserDAO {
	
	private static FlightUserDAO flightUserDAO = null;
	private FlightUserDAO() {};
	public static FlightUserDAO getInstance() {
		if(flightUserDAO == null) {
			flightUserDAO = new FlightUserDAO();
		}
		return flightUserDAO;
	}
	
	private Database database = Database.getInstance();
	
	private Map<String, Customer> customerMapList = new HashMap<>();
	
	// Create multiple Airport
	// Create multiple flights
	// Create seat for each flights
	// Create flightSchedule from with flightSeats 
	
	
	
	// register the User.
	public boolean registerUser(Customer customer) {
		if(!customerMapList.containsKey(customer.getName())) {
			customerMapList.put(customer.getName(), customer);
			System.out.println("Registration Successfull");
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	// search the flight
	
	public List<FlightSchedule> searchFlights(String from) throws EmptyFlightException{
		List<FlightSchedule> myList = new ArrayList<>();
		for(FlightSchedule flightSchedule : database.getListOfFlightSchedule()) {
			if(flightSchedule.getFlight().getDeparture().equals(from)){
				myList.add(flightSchedule);
			}
		}
		if(!(myList.size()> 0))
			throw new EmptyFlightException();
		
		return myList;
	}

	public boolean checkAvailibilty(FlightSchedule flightSchedule, int number) {
		return flightSchedule.getAvailableSeats() >= number ? Boolean.TRUE : Boolean.FALSE;
	}
	
	// get the seats in the flight

	public double bookSeats(FlightSchedule flightSchedule, int number) throws UnavailibilityException {
		double amount = 0.0;
		if(checkAvailibilty(flightSchedule, number)) {
			for(FlightSeat seat : flightSchedule.getfSeats()) {
				if(seat.getStatus().compareTo(BookingStatus.AVAILABLE) == 0) {
					seat.setStatus(BookingStatus.BOOKED);
					amount += seat.getFare();
				}
			}
			System.out.println("Booking Successful");
			return amount;
		}else {
			throw new UnavailibilityException();
		}
	
	}
	
	// block the seats

}
