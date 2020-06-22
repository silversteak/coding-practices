package com.system.design.FlightBooking;

import java.util.List;

public class BookingService {
	
	private static final BookingService BOOKING_INSTANCE = new BookingService();
	private BookingService() {};
	public static BookingService getInstance() {
		return BOOKING_INSTANCE;
	}
	
	// create the instances of rideService and userService
	
	private UserService userService = UserService.getInstance();
	private FlightService flightService = FlightService.getInstance();

	public void registerUser(Customer customer) {
		userService.registerUser(customer);
	}
	
	public List<FlightSchedule> searchFlights(String from) throws EmptyFlightException{
		return flightService.searchFlights(from);
	} 
	
	public double bookSeats(FlightSchedule flightSchedule, int number) throws UnavailibilityException{
		return flightService.bookSeats(flightSchedule, number);
	}
	
}
