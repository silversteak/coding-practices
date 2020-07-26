package com.system.design.Logger;

public interface IObservable {
	public void addObserver(IObserver iObserver);	
	public void removeOberser(IObserver iObserver);
	public void notifyObserver(MessageType messageType);
}
