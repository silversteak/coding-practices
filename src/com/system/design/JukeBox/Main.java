package com.system.design.JukeBox;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws EmptyPlayListException {

		List<Song> songs = new ArrayList<>();
		
		songs.add(new Song(1, "S1", "A1"));
		songs.add(new Song(2, "S2", "A2"));
		songs.add(new Song(3, "S3", "A3"));
		
		CD cd = new CD("DDLJ", songs);
		CD cd2 = new CD("KAJS",songs);
		
		List<CD> listOfCDs = new ArrayList<>();
		listOfCDs.add(cd);
		listOfCDs.add(cd2);
		
		//Playlist playlist = new Playlist(cd);
		
		JukeBox jukeBox = new JukeBox(1,listOfCDs, new User("Jonty"));
		
		jukeBox.createCDPlayer();
		jukeBox.createPlaylist();
		jukeBox.addSongsToPlaylist();
		jukeBox.playSong();
		
		
		
		
	}

}
