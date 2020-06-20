package com.system.design.CarBooking;

public abstract class User {
	
	private int userId;
	private String name;
	private int age;
	private Gender gender;
	private String address;
	public User(int userId, String name, int age, Gender gender, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address="
				+ address + "]";
	}

}
