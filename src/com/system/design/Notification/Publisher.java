package com.system.design.Notification;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements IPublish {

	private List<ISubscribe> listOfSubscriber = new ArrayList<>();
	
    private String availability;
	
	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
		notifySubscriber();
	}

	@Override
	public void addSubscriber(ISubscribe subscribe) {
		listOfSubscriber.add(subscribe);
	}

	@Override
	public void deleteSubscriber(ISubscribe subscribe) {
		listOfSubscriber.remove(subscribe);

	}

	@Override
	public void notifySubscriber() {
		for(ISubscribe subscriber : listOfSubscriber) {
				if(subscriber.getMode().compareTo(NotificationMode.SMS) == 0) {
					subscriber.update(new SMSNotification(123, "hello", 2323));
				}else if (subscriber.getMode().compareTo(NotificationMode.EMAIL) == 0){
					subscriber.update(new EmailNotification(2324, "2wdsdsdsf", "wedwfwefwf"));
			}
		}
		
	}

}
