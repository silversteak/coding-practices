package com.system.design.SnakeAndLadder;

public class LadderSquare extends Square {
	
	private int toPosition;

	public int getToPosition() {
		return toPosition;
	}

	public LadderSquare(int position, int toPosition) {
		super(position);
		this.toPosition = toPosition;
	}
	
	public int calcJump() {
		return this.toPosition - this.getPosition();
	}
	
	@Override
	public boolean isLadderSquare() {
		return true;
	}

	@Override
	public String toString() {
		return "LadderSquare [toPosition=" + toPosition + "]";
	}
	
	

}
