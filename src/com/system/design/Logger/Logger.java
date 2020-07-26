package com.system.design.Logger;

import java.util.HashMap;
import java.util.Map;

public class Logger extends Subject {
	
	private Map<MessageType, Boolean> loggerControl= new HashMap<>();
	public Logger(){
		loggerControl.put(MessageType.ERROR, Boolean.TRUE);
		loggerControl.put(MessageType.DEBUG, Boolean.TRUE);
		loggerControl.put(MessageType.INFO, Boolean.TRUE);
	}
	
	public void writeLogs(MessageType messageType, String content) {
		if(loggerControl.get(messageType) == Boolean.TRUE) {
			this.setContent(content);
			this.notifyObserver(messageType);
		}
	}
	
	public void enableLogging(MessageType messageType) {
		this.loggerControl.put(messageType, Boolean.TRUE);
	}
	
	public void disableLogging(MessageType messageType) {
		loggerControl.put(messageType, Boolean.FALSE);
	}
	
}
