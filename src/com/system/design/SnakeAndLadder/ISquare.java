package com.system.design.SnakeAndLadder;

public interface ISquare {

	public boolean isOccupied();
	public boolean isFirstSquare();
	public boolean isLastSquare();
	public boolean isSnakeSqaure();
	public boolean isLadderSquare();
	public int getPosition();
	
}
