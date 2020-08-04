package com.amazon.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumPathKnight {

	static class Cell{
		int x, y, dist;
		Cell(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	} 
	
	static boolean isSafe(int x, int y, int N) {
        return (x >= 1 && x <= N && y >= 1 && y <= N); 
    } 
	
	public int minStepToReachTarget(int knightpos[], int targetpos[], int N) {
	    
		int dirs[][] = {{-2,-1},{-1,-2},{1,-2},{2,-1},
						{-2,1},{-1,2},{1,2},{2,1}};
		
		boolean visited[][] = new boolean [N+1][N+1];

		Queue<Cell> queue = new LinkedList<>();

		queue.add(new Cell(knightpos[0], knightpos[1], 0));
		visited[knightpos[0]][knightpos[1]] = true; 
		while(!queue.isEmpty()) {
			Cell currentCell = queue.poll();
			
			//Check for the destination 
			if(currentCell.x == targetpos[0] && currentCell.y == targetpos[1])
				return currentCell.dist;
			
			for(int dir[] : dirs) {
				int nextRow = currentCell.x + dir[0];
				int nextCol = currentCell.y + dir[1];
				int nextDis = currentCell.dist + 1;
				
				if(isSafe(nextRow, nextCol, N) && !visited[nextRow][nextCol]) {
					visited[nextRow][nextCol] = true;
					queue.add(new Cell(nextRow, nextCol, nextDis));
				}
			}
		}
		
		return Integer.MAX_VALUE;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
