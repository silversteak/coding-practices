package com.system.design.JukeBox;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	
	private CD cd;
	private List<Song> queue;
	private int index = 0;
	public Playlist(CD cd) {
		super();
		this.cd = cd;
		this.queue = new ArrayList<>();
	}
	
	private DAOLayer daoLayer = DAOLayer.getInstance();
	
	public void addSongsToPlaylist() {
		daoLayer.addSongsToPlaylist(this.queue, this.cd);
	}
	
	public void removeSongFromPlaylist(Song song) {
		daoLayer.removeSongFromPlaylist(song, this.queue);
	}
	
	public Song playSong() throws EmptyPlayListException {
		if(queue != null) {
			System.out.println(queue.get(index));
			return queue.get(index++);
		}else {
			throw new EmptyPlayListException();
		}
		
	}
	
	public Song nextSong() throws EmptyPlayListException {
		if(queue.get(index+1) != null) {
			System.out.println(queue.get(++index));
			return queue.get(index);
		}else {
			throw new EmptyPlayListException();
		}
	};
	
	public Song prevSong() throws EmptyPlayListException {
		if(queue.get(index-1) != null) {
			System.out.println(queue.get(--index));
			return queue.get(index);
		}else {
			throw new EmptyPlayListException();
		}
	}
	
	
	
}
