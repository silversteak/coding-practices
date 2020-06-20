package com.system.design.JukeBox;

import java.util.List;

public class DAOLayer {
	
	private DAOLayer() {};
	private static DAOLayer daoLayer = null;
	
	public static DAOLayer getInstance() {
		if(daoLayer == null) {
			daoLayer = new DAOLayer();
		}
		return daoLayer;
	}

	public void addSongsToPlaylist(List<Song> queue, CD cd) {
		for(Song song : cd.getListOfSongs()) {
			queue.add(song);
		}
	}

	public void removeSongFromPlaylist(Song song, List<Song> queue) {
		int removeIndex = -1;
		int i = 0;
		for(Song el : queue) {
			if(el.getSongId() == song.getSongId()) {
				removeIndex = i;
				break;
			}
			i++;
		}
		queue.remove(removeIndex);
		
	}
	

}
