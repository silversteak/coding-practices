package com.system.design.TickTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private int matrix[][];
	private int currentPlayer;
	private User winner;
	private int n;
	private List<Move> listOfMoves;

	public Board(int n) {
		this.n = n;
		this.matrix = new int [n][n];
		listOfMoves = new ArrayList<>();
	}

	public int makeMove(Move m) {

		int row = m.getRow(),  col = m.getCol();
		this.currentPlayer = m.getPlayer().getId() == 0 ? -1 : 1;

		if(row < 0 || col < 0 || row >= n || col >= n){
			throw new IllegalArgumentException("Move is not valid");
		}else if (matrix[row][col] != 0) {
			throw new IllegalArgumentException("Cell is already occupied");
		}else if (currentPlayer != 1 && currentPlayer != -1) {
			throw new IllegalArgumentException("Invalid players");
		}else {

			listOfMoves.add(m);

			matrix[row][col] = currentPlayer;

			boolean winRow = true, winCol = true, winDiag = true, winRevDiag = true;

			for(int i = 0; i < n; i++) {
				//row match
				if(matrix[row][i] != currentPlayer) {
					winRow = false;
				}
				//Col Match
				if(matrix[i][col] != currentPlayer) {
					winCol = false;
				}
				if(matrix[i][i] != currentPlayer) {
					winDiag = false;
				}
				if(matrix[i][n-i-1] != currentPlayer) {
					winRevDiag = false;
				}

			}

			if(winRow || winCol || winDiag || winRevDiag) {
				setWinner(m.getPlayer());
				m.getPlayer().winGames++;
				return currentPlayer;
			}	
		}
		return 0;

	}
	
	public void reserMatrix() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}


	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public User getWinner() {
		return winner;
	}

	public void setWinner(User winner) {
		this.winner = winner;
	}


	public List<Move> getListOfMoves() {
		return listOfMoves;
	}

	public void setListOfMoves(List<Move> listOfMoves) {
		this.listOfMoves = listOfMoves;
	}


	





}
