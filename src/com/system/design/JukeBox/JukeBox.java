package com.system.design.JukeBox;

import java.util.List;

public class JukeBox {
	
	private Integer jukeBoxId;
	private List<CD> listOfCD;
	private User user;
	private CDPlayer cdPlayer;
	
	public JukeBox(Integer jukeBoxId, List<CD> listOfCD, User user) {
		super();
		this.jukeBoxId = jukeBoxId;
		this.listOfCD = listOfCD;
		this.user = user;
	}
	
	public void createCDPlayer() {
		cdPlayer = new CDPlayer("New CD Player", this.listOfCD.get(0));
	}
	
	public void createPlaylist() {
		Playlist playlist = new Playlist(this.listOfCD.get(0));
		cdPlayer.setPlaylist(playlist);
	}
	
	public void addSongsToPlaylist() {
		if(cdPlayer.getPlaylist() != null) {
			cdPlayer.getPlaylist().addSongsToPlaylist();			
		}
	}
	
	public void playSong() throws EmptyPlayListException {
		cdPlayer.getPlaylist().playSong();
		cdPlayer.getPlaylist().playSong();
		cdPlayer.getPlaylist().prevSong();
	} 
	
	

}
