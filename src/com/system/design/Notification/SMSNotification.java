package com.system.design.Notification;

public class SMSNotification extends Notification {

	private int mobileNumber;
	
	public SMSNotification(int id, String content, int mobileNumber) {
		super(id, content);
		this.mobileNumber = mobileNumber;
	}

	@Override
	public boolean send() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "SMSNotification [mobileNumber=" + mobileNumber + "]";
	}

}
