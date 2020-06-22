package com.system.design.Notification;

public interface ISubscribe {
	public NotificationMode getMode();
	public void update(Notification notification);	
}
