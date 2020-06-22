package com.system.design.ParkingLot;

public class ParkingSpot {
	
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private boolean isAvailable = Boolean.TRUE;
	
	public ParkingSpot(VehicleSize spotSize) {
		super();
		this.spotSize = spotSize;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public VehicleSize getSpotSize() {
		return spotSize;
	}
	
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "ParkingSpot [vehicle=" + vehicle + ", spotSize=" + spotSize + ", isAvailable=" + isAvailable + "]";
	}
	
	
}
