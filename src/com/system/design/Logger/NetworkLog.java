package com.system.design.Logger;

public class NetworkLog implements IObserver {

	private Subject subject;
	
	public NetworkLog(Subject subject) {
		super();
		this.subject = subject;
	}


	@Override
	public void update() {
		subject.getContent();
	}

}
