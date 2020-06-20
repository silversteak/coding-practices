package com.system.design.CarBooking;

public abstract class Vehicle {
	
	private String vehicleName;
	private int vehicleNumber;
	private int availableSeats;
	private VehicleType vehicleType;
	private Location location;
	
	public static int AVAILABLE = 4;
	
	public Vehicle(String vehicleName, int vehicleNumber, VehicleType vehicleType,
			Location location) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.availableSeats = AVAILABLE;
		this.vehicleType = vehicleType;
		this.location = location;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailable(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	
}

