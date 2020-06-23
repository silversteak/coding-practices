package com.system.design.SnakeAndLadder;

import java.util.Random;

public class Dice {
	
	private final static int MAX = 6;
	
	public int rollDice() {
		Random random = new Random();
		return 1+random.nextInt(MAX);
	}
	

}
