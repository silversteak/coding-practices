package com.system.design.SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public static void main(String[] args) {
		
		Player player1 = new Player("Jonty");
		Player player2 = new Player("Deepu");
		
		List<Player> listOfPlayer = new ArrayList<>();
		listOfPlayer.add(player1);
		listOfPlayer.add(player2);
	
		int [][] snakesFromTo = { {11 ,5} };
		int [][] laddersFromTo = { {2 ,6} , {7 ,9} };
		
		Board board = new Board(30, laddersFromTo, snakesFromTo);
		board.setBoard();
		
		for(Player p : listOfPlayer) {
			p.setCurrentSquare(board.getFirstInitialSquare());
		}
		
		Dice dice = new Dice();
		
		while(board.getWinner() == null) {		
			for(Player p : listOfPlayer) {
				int roll = dice.rollDice();
				board.makeMove(p, roll);
			}

		}
		
		System.out.println(board.getWinner());
		
		
	}

}
