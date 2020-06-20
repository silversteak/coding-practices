package com.system.design.CarBooking;

public class Driver extends User {

	private boolean isAvailable;
	private Vehicle vehicle;

	public Driver(int userId, String name, int age, Gender gender, String address, boolean isAvailable,
			Vehicle vehicle) {
		super(userId, name, age, gender, address);
		this.isAvailable = isAvailable;
		this.vehicle = vehicle;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	

}
