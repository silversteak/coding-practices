package com.system.design.Logger;

public class FileLog implements IObserver {

	private Subject subject;
	
	public FileLog(Subject subject) {
		super();
		this.subject = subject;
	}

	@Override
	public void update() {
		subject.getContent();
	}

}
