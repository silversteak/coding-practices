package com.system.design.SnakeAndLadder;

import java.util.LinkedList;
import java.util.List;

public class Board {

	private int numOfSquare;
	private int [][] ladders;
	private int [][] snakes;
	private Player currentPlayer;
	private Player winner;
	private ISquare firstInitialSquare;

	public ISquare getFirstInitialSquare() {
		return firstInitialSquare;
	}

	private List<ISquare> squares = new LinkedList<>();
	public Board(int numOfSquare, int[][] ladders, int[][] snakes) {
		super();
		this.numOfSquare = numOfSquare;
		this.ladders = ladders;
		this.snakes = snakes;
	}
	
	public void setBoard() {
		squares.add(new FirstSquare(0));
		
		this.firstInitialSquare = squares.get(0);
		
		for(int i = 1; i < numOfSquare; i++) {
			squares.add(new Square(i));
		}
		squares.add(new LastSquare(numOfSquare));
		
		for(int i = 0; i < ladders.length; i++) {
			int index = ladders[i][0];
			int toPosition = ladders[i][1];
			squares.set(index, new LadderSquare(index, toPosition));
		}
		
		for(int i = 0; i < snakes.length; i++) {
			int index = snakes[i][0];
			int toPosition = snakes[i][1];
			squares.set(index, new SnakeSquare(index, toPosition));
		}
		
	}
	
	public void makeMove(Player player ,int diceRoll) {
		this.setCurrentPlayer(player);
		
		//Get the lastSquare of the current player
		ISquare lastSquareOfCurrentPlayer = currentPlayer.getCurrentSquare();
		
		int lastIndex = lastSquareOfCurrentPlayer.getPosition();
		int nextIndex = lastIndex + diceRoll;
		if(nextIndex <= this.numOfSquare) {
			ISquare newSquareOfCurrentPlyer = squares.get(nextIndex);
			
			if(newSquareOfCurrentPlyer.isLastSquare()) {
				this.winner = this.currentPlayer;
			}else if(newSquareOfCurrentPlyer.isLadderSquare()) {
				LadderSquare ladderSquare = (LadderSquare) newSquareOfCurrentPlyer;
				int toPosition = ladderSquare.getToPosition();
				newSquareOfCurrentPlyer = squares.get(toPosition);
			}else if(newSquareOfCurrentPlyer.isSnakeSqaure()) {
				SnakeSquare snakeSquare = (SnakeSquare) newSquareOfCurrentPlyer;
				int toPosition = snakeSquare.getToPosition();
				newSquareOfCurrentPlyer = squares.get(toPosition);
			}
			
			this.currentPlayer.setCurrentSquare(newSquareOfCurrentPlyer);
		}
		

		//Check for the valid move lastSquareIndex + diceRoll
		
		//Check the current status of the Square
		/*
		 * 1. if it is a ladder then move ahead of the currentSquare
		 * 2. if snake then find the square that it points to
		 * 3. if its a normal sqare
		 * */
		// if its the last square then set player to the winner
		// Set the require Square to the player.
		
		return;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
}
