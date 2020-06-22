package com.system.design.FlightBooking;

public class UserService {

	private static UserService userService = null;
	private UserService() {};
	
	public static UserService getInstance() {
		if(userService == null) {
			userService = new UserService();
		}
		return userService;
	}
	
	private FlightUserDAO flightUserDAO =FlightUserDAO.getInstance();
	
	// Register the customer 
	public boolean registerUser(Customer customer) {
		return flightUserDAO.registerUser(customer);
	}
	
}
