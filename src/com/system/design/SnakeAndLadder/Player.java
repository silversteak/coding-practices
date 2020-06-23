package com.system.design.SnakeAndLadder;

public class Player {
	
	private String name;
	private ISquare currentSquare;
	
	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ISquare getCurrentSquare() {
		return currentSquare;
	}

	public void setCurrentSquare(ISquare currentSquare) {
		this.currentSquare = currentSquare;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", currentSquare=" + currentSquare +"]";
	}
}
