package com.system.design.TickTacToe;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Board board = new Board(3);
		User user1 = new User("tauseef", 1);
		User user2 = new User("Deepa", 0);
		
		List<Move> listOfMoves = new ArrayList<>();
		
		listOfMoves.add(new Move(user1, 0, 0));
		listOfMoves.add(new Move(user2, 0, 1));
		listOfMoves.add(new Move(user1, 0, 2));
		listOfMoves.add(new Move(user2, 1, 1));
		listOfMoves.add(new Move(user1, 1, 0));
		listOfMoves.add(new Move(user2, 1, 2));
		listOfMoves.add(new Move(user1, 2, 0));
		listOfMoves.add(new Move(user2, 2, 2));
		listOfMoves.add(new Move(user1, 0, 0));
		
		int gamesPlayed = 0;
		
		while(true) {			
			for(Move e : listOfMoves) {
				
				try {
					int winner = board.makeMove(e);
					if(winner != 0) {
						System.out.println(board.getWinner());
					}					
				}catch(Exception ex) {
					System.out.println(ex);
					board.reserMatrix();
				}
			}
			
			
			if(++gamesPlayed > 10)
				break;
			
			
		}
		
		System.out.println(user1.toString());
		System.out.println(user2.toString());
		
		

	}

}
