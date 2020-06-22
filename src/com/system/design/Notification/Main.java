package com.system.design.Notification;

public class Main {

	public static void main(String[] args) {
		
		
		Subscriber1 subscriber1 = new Subscriber1(NotificationMode.SMS);
		Subscriber2 subscriber2 = new Subscriber2(NotificationMode.EMAIL);
		Subscriber3 subscriber3 = new Subscriber3(NotificationMode.SMS);
		
		Publisher publisher = new Publisher();
		
		publisher.addSubscriber(subscriber1);
		publisher.addSubscriber(subscriber2);
		publisher.addSubscriber(subscriber3);
		
		publisher.setAvailability("hello");
		

	}

}
