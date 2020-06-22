package com.system.design.FlightBooking;

public class Customer {

	private String name;
	private String address;
	private String mobileNo;
	public Customer(String name, String address, String mobileNo) {
		super();
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", mobileNo=" + mobileNo + "]";
	}
	
	
}
