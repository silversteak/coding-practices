package com.system.design.CarBooking;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {

	public static UserDAO userDAO = null;

	public Map<Integer, Rider> riderMap = new HashMap<Integer, Rider>();

	public Map<Integer, Driver> driverMap = new HashMap<Integer, Driver>();

	public Map<Integer, Vehicle> vehicleMap = new HashMap<Integer, Vehicle>();

	private UserDAO() {

	}

	public static UserDAO getInstance() {
		if (userDAO == null) {
			userDAO = new UserDAO();
		}

		return userDAO;
	}

	public Driver createDriver(int userId, String name, int age, Gender gender, String address, boolean isAvailable,
			Vehicle vehicle) throws CreateException {
		Driver driver = new Driver(userId, name, age, gender, address, isAvailable, vehicle);

		if (driver == null || driverMap.containsKey(driver.getUserId())) {
			throw new CreateException();
		}

		driverMap.put(userId, driver);
		vehicleMap.put(driver.getVehicle().getVehicleNumber(), vehicle);

		return driver;
	}

	public Rider createRider(int userId, String name, int age, Gender gender, String address, Location location)
			throws CreateException {
		Rider rider = new Rider(userId, name, age, gender, address, location);

		if (rider == null || riderMap.containsKey(userId)) {
			throw new CreateException();
		}

		riderMap.put(userId, rider);

		return rider;

	}

	public boolean updateLocation(Integer vehileNumber, Location location) {

		if (vehicleMap.containsKey(vehileNumber)) {
			vehicleMap.get(vehileNumber).setLocation(location);
			return true;
		}
		return false;
	}

	public boolean checkAvailibility(Integer driverId) throws Exception {
		if (driverMap.containsKey(driverId)) {
			if (driverMap.get(driverId).isAvailable()) {
				return true;
			}

		} else {
			throw new Exception();
		}

		return false;
	}

	public static UserDAO getUserDAO() {
		return userDAO;
	}

	public static void setUserDAO(UserDAO userDAO) {
		UserDAO.userDAO = userDAO;
	}

	public Map<Integer, Rider> getRiderMap() {
		return riderMap;
	}

	public void setRiderMap(Map<Integer, Rider> riderMap) {
		this.riderMap = riderMap;
	}

	public Map<Integer, Driver> getDriverMap() {
		return driverMap;
	}

	public void setDriverMap(Map<Integer, Driver> driverMap) {
		this.driverMap = driverMap;
	}

	public Map<Integer, Vehicle> getVehicleMap() {
		return vehicleMap;
	}

	public void setVehicleMap(Map<Integer, Vehicle> vehicleMap) {
		this.vehicleMap = vehicleMap;
	}

}
