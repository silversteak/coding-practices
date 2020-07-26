package com.system.design.Logger;

public class ConsoleLogger implements IObserver {

	private Subject subject;
	
	public ConsoleLogger(Subject subject) {
		super();
		this.subject = subject;
	}



	@Override
	public void update() {
		subject.getContent();
	}

}
