package com.system.design.CarBooking;

import java.util.ArrayList;
import java.util.List;

public class Rider extends User {
	
	private Location location;
	private List<Ride> rides = new ArrayList<>();
	
	public Rider(int userId, String name, int age, Gender gender, String address, Location location) {
		super(userId, name, age, gender, address);
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Ride> getRides() {
		return rides;
	}

	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}
	
	

}
