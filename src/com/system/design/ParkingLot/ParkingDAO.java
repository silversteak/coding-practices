package com.system.design.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingDAO {
	
	private ParkingDAO() {};

	private static ParkingDAO parkingDAO = null;
	
	public static ParkingDAO getInstance() {
		if(parkingDAO == null) {
			parkingDAO = new ParkingDAO();
		}
		return parkingDAO;
	}
	
	
	public void populateTheStore(Map<Integer, ParkingSpot> store) {
		int numberOfBikeSpot = 15;
		int numberOfCarSpot = 10;
		int numberOfBus = 3;
		int totalValidSpot = numberOfBikeSpot + numberOfBus + numberOfCarSpot;
		
		int i = 1;
		
		for(; i <= numberOfBikeSpot; i++)
			store.put(i, new ParkingSpot(VehicleSize.SMALL));
		
		for(; i <= numberOfCarSpot + numberOfBikeSpot; i++)
			store.put(i, new ParkingSpot(VehicleSize.MEDIUM));
		
		for(; i <= totalValidSpot; i++)
			store.put(i, new ParkingSpot(VehicleSize.BIG));
		
	}
	
	public boolean parkVehicle(Vehicle vehicle,Map<Integer, ParkingSpot> store) {
		for(ParkingSpot parkingSpot : store.values()) {
			if(vehicle.vehicleSize == parkingSpot.getSpotSize() && parkingSpot.isAvailable()) {
				parkingSpot.setVehicle(vehicle);
				parkingSpot.setAvailable(Boolean.FALSE);
				System.out.println("Vehicle parked" + parkingSpot.toString());
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
	
	public boolean freeVehicle(Vehicle vehicle,Map<Integer, ParkingSpot> store) {
		for(ParkingSpot parkingSpot : store.values()) {
			if(!parkingSpot.isAvailable() && vehicle.getLicensePlate().equals(parkingSpot.getVehicle().getLicensePlate())) {
				parkingSpot.setVehicle(null);
				parkingSpot.setAvailable(Boolean.TRUE);
				return Boolean.TRUE;
			}
		}
		System.out.println("Vehicle not found");
		return Boolean.FALSE;
	}
	
	
}
