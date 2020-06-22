package com.system.design.Notification;

public class EmailNotification extends Notification {

	private String emailId;
	
	public EmailNotification(int id, String content, String emailId) {
		super(id, content);
		this.emailId = emailId;
	}

	@Override
	public boolean send() {
		return false;
	}

	@Override
	public String toString() {
		return "EmailNotification [emailId=" + emailId + "]";
	}

}
