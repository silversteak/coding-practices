package com.system.design.ParkingLot;

public class Bus extends Vehicle {

	public Bus(String licensePlate) {
		super(licensePlate);
		this.vehicleSize = VehicleSize.BIG;
	}

}
