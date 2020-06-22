package com.system.design.Notification;

public abstract class Notification {
	private int id;
	private String content;
	public abstract boolean send();
	public Notification(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	@Override
	public String toString() {
		return "Notification [id=" + id + ", content=" + content + "]";
	}
	
}
