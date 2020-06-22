package com.system.design.Notification;

public interface IPublish {

	public void addSubscriber(ISubscribe subscribe);
	public void deleteSubscriber(ISubscribe subscribe);
	public void notifySubscriber();
}
