package com.system.design.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
	
	private String licensePlate;
	protected VehicleSize vehicleSize;
	private List<ParkingSpot> listOfParkingSpots;
	
	public Vehicle(String licensePlate) {
		super();
		this.licensePlate = licensePlate;
		this.listOfParkingSpots = new ArrayList<>();
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public VehicleSize getVehicleSize() {
		return vehicleSize;
	}
	public void setVehicleSize(VehicleSize vehicleSize) {
		this.vehicleSize = vehicleSize;
	}
	public List<ParkingSpot> getListOfParkingSpots() {
		return listOfParkingSpots;
	}
	public void setListOfParkingSpots(List<ParkingSpot> listOfParkingSpots) {
		this.listOfParkingSpots = listOfParkingSpots;
	}
	
	
	
}
