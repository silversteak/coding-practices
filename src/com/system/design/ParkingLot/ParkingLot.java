package com.system.design.ParkingLot;

public class ParkingLot {
	
	private Level[] levels;
	private final int NUM_LEVELS = 5;
	
	// Constructor;
	public ParkingLot() {
		super();
		this.levels = new Level[NUM_LEVELS];
		for(int i = 0; i < NUM_LEVELS; i++) {
			this.levels[i] = new Level(i);
		}
	}
	
	public void parkVehicle(Vehicle vehicle) {
		boolean flag = false;
		for(Level level : this.levels) {
			flag = level.parkVehicle(vehicle);
			if(flag) return;
		}
		
		System.out.println("No spaces left");
		
	}
	
	public void freeVehicle(Vehicle vehicle) {
		boolean flag = false;
		for(Level level : this.levels) {
			flag = level.freeVehicle(vehicle);
			if(flag) return;
		}
		
		System.out.println("No vehicle found");
		
	}
	
	
	

}
