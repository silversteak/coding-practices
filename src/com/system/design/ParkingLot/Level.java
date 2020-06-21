package com.system.design.ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Level {

	private int floor;
	private Map<Integer, Map<Integer, ParkingSpot>> spaces;
	private int totalSpace = 50;
	private ParkingDAO parkingDAO = ParkingDAO.getInstance();

	public Level(int floor) {
		super();
		this.floor = floor;
		//this.spots = new ParkingSpot[availableSpots];
	}
	
	public boolean parkVehicle(Vehicle vehicle) {
		if(parkingDAO != null) {
			return parkingDAO.parkVehicle(vehicle);
		}
		return Boolean.FALSE;
	}
	
	
	public boolean freeVehicle(Vehicle vehicle) {
		if(parkingDAO != null) {
			return parkingDAO.freeVehicle(vehicle);
		}
		return Boolean.FALSE;
	}
	
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	
	
	
	
	
	
	
}
