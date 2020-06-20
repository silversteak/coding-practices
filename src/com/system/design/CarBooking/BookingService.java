package com.system.design.CarBooking;

public class BookingService {
	
	private static final BookingService BOOKING_INSTANCE = new BookingService();
	private BookingService() {};
	public static BookingService getInstance() {
		return BOOKING_INSTANCE;
	}
	
	// create the instances of rideService and userService
	
	private UserService userService = UserService.getInstance();
	private RideService rideService = RideService.getInstance(); 
	
	// registerDriver
	
	public Driver registerDriver(int userId, String name, int age, Gender gender, String address, boolean isAvailable, Vehicle vehicle) throws CreateException {
		Driver driver = null;
		if(driver == null) {
			driver = userService.registerDriver(userId, name, age, gender, address, isAvailable, vehicle);
		}
		return driver;
	}	
	
	// registerRider
	
	public Rider registerRider(int userId, String name, int age, Gender gender, String address, Location location) throws CreateException {
		Rider rider = null;
		if(rider == null) {
			rider = userService.registerRider(userId, name, age, gender, address, location);
		}
		
		return rider;
		
		
	}	
	// update the location
	
	public boolean updateLocation(Integer vehileNumber, Location location) {
		return userService.updateLocation(vehileNumber, location);
	}
	
	// book the cab
	
	public Driver bookRide(int riderId,Location fromLocation,Location toLocation) throws DriverNotAvailable{
		Driver driver = null;
		if(driver == null) {
			driver = rideService.bookRide(riderId, fromLocation, toLocation);
		}
		
		return driver;
	}
	
	
	// calc_distance
	

}
