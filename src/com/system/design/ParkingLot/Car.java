package com.system.design.ParkingLot;

public class Car extends Vehicle {

	public Car(String licensePlate) {
		super(licensePlate);
		this.vehicleSize = VehicleSize.MEDIUM;
	}
	
}
