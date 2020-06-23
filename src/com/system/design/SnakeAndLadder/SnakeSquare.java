package com.system.design.SnakeAndLadder;

public class SnakeSquare extends Square {
	
	private int toPosition;
	
	public SnakeSquare(int position, int toPosition) {
		super(position);
		this.toPosition = toPosition;
	}
	
	public int calcJump() {
		return this.getPosition() - this.toPosition;
	}
	
	@Override
	public boolean isSnakeSqaure() {
		return true;
	}

	public int getToPosition() {
		return toPosition;
	}

	@Override
	public String toString() {
		return "SnakeSquare [toPosition=" + toPosition + "]";
	}
	
	
}
