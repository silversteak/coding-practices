package com.system.design.SnakeAndLadder;

public class Square implements ISquare {

	private int position;
	
	public Square(int position) {
		super();
		this.position = position;
	}

	@Override
	public boolean isOccupied() {
		return false;
	}

	@Override
	public boolean isFirstSquare() {
		return false;
	}

	@Override
	public boolean isLastSquare() {
		return false;
	}

	@Override
	public boolean isSnakeSqaure() {
		return false;
	}

	@Override
	public boolean isLadderSquare() {
		return false;
	}

	@Override
	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "Square [position=" + position + "]";
	}
	
}
