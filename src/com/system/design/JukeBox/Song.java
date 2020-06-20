package com.system.design.JukeBox;

public class Song {

	private Integer songId;
	private String songName;
	private String songArtist;
	public Song(Integer songId, String songName, String songArtist) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.songArtist = songArtist;
	}
	public Integer getSongId() {
		return songId;
	}
	public void setSongId(Integer songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSongArtist() {
		return songArtist;
	}
	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}
	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + ", songArtist=" + songArtist + "]";
	}
	
	
}
