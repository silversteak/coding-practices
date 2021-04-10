package com.system.design.TickTacToe;

public class Move {
	
	private User player;
	private int row;
	private int col;
	
	public Move(User player, int row, int col) {
		super();
		this.player = player;
		this.row = row;
		this.col = col;
	}

	public User getPlayer() {
		return player;
	}

	public void setPlayer(User player) {
		this.player = player;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
}
