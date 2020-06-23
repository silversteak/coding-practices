package com.system.design.SnakeAndLadder;

public class MainSnakeLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dice dice = new Dice();
		
		for(int i = 0; i < 10; i++) {
			System.out.println(dice.rollDice());
		}
		
	}

}
