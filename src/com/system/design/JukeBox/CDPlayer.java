package com.system.design.JukeBox;

public class CDPlayer {
	private String cDPayerName;
	private CD cd;
	private Playlist playlist;
	
	public CDPlayer(String cDPayerName, CD cd) {
		super();
		this.cDPayerName = cDPayerName;
		this.cd = cd;
	}

	public CDPlayer(String cDPayerName) {
		super();
		this.cDPayerName = cDPayerName;
	}

	public String getcDPayerName() {
		return cDPayerName;
	}

	public void setcDPayerName(String cDPayerName) {
		this.cDPayerName = cDPayerName;
	}

	public CD getCd() {
		return cd;
	}

	public void setCd(CD cd) {
		this.cd = cd;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	
	
	

}
