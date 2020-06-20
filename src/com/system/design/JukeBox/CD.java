package com.system.design.JukeBox;

import java.util.List;

public class CD {

	private String cDName;
	private List<Song> listOfSongs;
	
	public CD(String cDName, List<Song> listOfSongs) {
		super();
		this.cDName = cDName;
		this.listOfSongs = listOfSongs;
	}
	public String getcDName() {
		return cDName;
	}
	public void setcDName(String cDName) {
		this.cDName = cDName;
	}
	public List<Song> getListOfSongs() {
		return listOfSongs;
	}
	public void setListOfSongs(List<Song> listOfSongs) {
		this.listOfSongs = listOfSongs;
	}
	@Override
	public String toString() {
		return "CD [cDName=" + cDName + ", listOfSongs=" + listOfSongs + "]";
	}
	
}
