package com.system.design.CarBooking;

public class Ride {

	private Driver driver;
	private Rider rider;
	private Location fromLocation;
	private Location toLocation;
	public Ride(Driver driver, Rider rider, Location fromLocation, Location toLocation) {
		super();
		this.driver = driver;
		this.rider = rider;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Rider getRider() {
		return rider;
	}
	public void setRider(Rider rider) {
		this.rider = rider;
	}
	public Location getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(Location fromLocation) {
		this.fromLocation = fromLocation;
	}
	public Location getToLocation() {
		return toLocation;
	}
	public void setToLocation(Location toLocation) {
		this.toLocation = toLocation;
	}
	@Override
	public String toString() {
		return "Ride [driver=" + driver + ", rider=" + rider + ", fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + "]";
	}
	
}
