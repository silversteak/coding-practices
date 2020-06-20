package com.system.design.CarBooking;

import java.util.ArrayList;
import java.util.List;

public class RideService {

	private static final RideService RIDE_SERVICE_INSTANCE = new RideService();
	
	private static Integer MAX_DISTANCE =  1000;
	
	private UserDAO userDAO = UserDAO.getInstance();
	
	private RideService() {};
	
	public static RideService getInstance() {
		return RIDE_SERVICE_INSTANCE;
	}
	
	// book ride
	
	public Driver bookRide(int riderId,Location fromLocation,Location toLocation) throws DriverNotAvailable{
		Rider rider = userDAO.riderMap.get(riderId);
		List<Driver> drivers= fetchAllDrivers(fromLocation);
		if(drivers.isEmpty()) {
			throw new DriverNotAvailable();
		}
		Driver driver = drivers.get(0);
		driver.setAvailable(false);
		
		Ride ride = new Ride(driver, rider, fromLocation, toLocation);
		rider.getRides().add(ride);
		
		return driver;
		
		
		
		
	}

	private List<Driver> fetchAllDrivers(Location fromLocation) {
		
		List<Driver> drivers = new ArrayList<>();
		
		for(Driver driver : userDAO.driverMap.values()) {
			
			if(driver.isAvailable() && checkDistance(fromLocation, driver.getVehicle().getLocation())) {
				drivers.add(driver);
			}
			
		}
		
		return drivers;
		
		
	}

	private boolean checkDistance(Location fromLocation, Location location) {

		Double distance = Math.sqrt(Math.abs(Math.pow(fromLocation.getX() - location.getX(), 2) - Math.pow(fromLocation.getY() - location.getY(), 2))); 
		
		return distance < MAX_DISTANCE ? true : false;
	}
	
	// fetchAllDrivers
	// checkAvailibilty
	// checkDistance
	
	
	
}
