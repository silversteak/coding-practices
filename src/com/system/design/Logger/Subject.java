package com.system.design.Logger;

import java.util.ArrayList;
import java.util.List;

public class Subject implements IObservable{

	private List<IObserver> listOfObsers = new ArrayList<>();
	private String content;
	@Override
	public void addObserver(IObserver ob) {
		listOfObsers.add(ob);
	}

	@Override
	public void removeOberser(IObserver ob) {
		listOfObsers.remove(ob);
	}
	
	@Override
	public void notifyObserver(MessageType messageType) {
		for(IObserver el : listOfObsers) {
			el.update();
		}
	}

	public List<IObserver> getListOfObsers() {
		return listOfObsers;
	}

	public void setListOfObsers(List<IObserver> listOfObsers) {
		this.listOfObsers = listOfObsers;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
