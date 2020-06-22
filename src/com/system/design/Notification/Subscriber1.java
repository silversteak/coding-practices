package com.system.design.Notification;

public class Subscriber1 implements ISubscribe, IDisplay {

	private String content;
	private NotificationMode mode;

	public Subscriber1(NotificationMode mode) {
		super();
		this.mode = mode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

	@Override
	public void update(Notification notification) {
		System.out.println(notification.toString());
	}

	@Override
	public void display() {
		System.out.println(this.getContent());
	}

	@Override
	public NotificationMode getMode() {
		return this.mode;
	}

}
