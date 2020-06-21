package com.system.design.ParkingLot;

public class Bike extends Vehicle {

	public Bike(String licensePlate) {
		super(licensePlate);
		this.vehicleSize = VehicleSize.SMALL;
	}

}
