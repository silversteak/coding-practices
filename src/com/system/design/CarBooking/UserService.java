package com.system.design.CarBooking;

public class UserService {

	private static final UserService USER_SERVICE_INSTANCE = new UserService();
	private UserService() {};
	
	private UserDAO userDAO = UserDAO.getInstance();
	
	public static UserService getInstance() {
		return USER_SERVICE_INSTANCE;
	}
	
	public Driver registerDriver(int userId, String name, int age, Gender gender, String address, boolean isAvailable, Vehicle vehicle) throws CreateException {
		return userDAO.createDriver(userId, name, age, gender, address, isAvailable, vehicle);
	}
	
	public Rider registerRider(int userId, String name, int age, Gender gender, String address, Location location) throws CreateException {
		return userDAO.createRider(userId, name, age, gender, address, location);
	}
	
	public boolean updateLocation(Integer vehileNumber, Location location) {
		return userDAO.updateLocation(vehileNumber, location);
	}
	
	public boolean checkAvailibility(Integer driverId) throws Exception{
		return userDAO.checkAvailibility(driverId);
		
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public static UserService getUserServiceInstance() {
		return USER_SERVICE_INSTANCE;
	}
	
	
}
