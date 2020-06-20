package com.system.design.TickTacToe;

public class User {

	private String name;
	private int id;
	public static int totalGames;
	public static int winGames;
	private static int loseGames;
	
	public User(String name, int id) {
		this.name = name;
		this.setId(id);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalGames() {
		return totalGames;
	}
	public int getWinGames() {
		return winGames;
	}

	public int getLoseGames() {
		return loseGames;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", totalGames=" + totalGames + ", winGames=" + winGames + ", loseGames="
				+ loseGames + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
}
