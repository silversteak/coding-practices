package com.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	static public class Cell{
		int row, col;
		public Cell(int x, int y) {
			this.row = x;
			this.col = y;
		}
	}
	
	static public boolean isDelimeter(Cell temp) {
		return (temp.col == -1 || temp.row == -1) ? true : false;
	}
	
	static boolean isValid(int i, int j, int row, int col) { 
        return (i >= 0 && j >= 0 && i < row && j < col); 
    }
	
	// orange remaining 
    static boolean checkAll(int arr[][], int R, int C) 
    { 
         for (int i=0; i<R; i++) 
               for (int j=0; j<C; j++) 
                  if (arr[i][j] == 1) 
                     return true; 
         return false; 
    } 
	
	static public int rotOranges(int a[][],int R, int C){
		
		Queue<Cell> queue = new LinkedList<>(); 
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(a[i][j] == 2)
					queue.add(new Cell(i, j));
			}
		}
		
		queue.add(new Cell(-1, -1));
		
		int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};
		int count = 0;
		while(!queue.isEmpty()) {
			
			boolean isFlag = false;
			
			while(!isDelimeter(queue.peek())) {
				Cell temp = queue.poll();
				for(int dir[] : dirs) {
					int currentRow = temp.row + dir[0];
					int currentCol = temp.col + dir[1];
					if(isValid(currentRow, currentCol, R, C)
							&& a[currentRow][currentCol] == 1) {
						if(!isFlag) {
							isFlag = true;
							count++;
						}
						
						a[currentRow][currentCol] = 2;
						queue.add(new Cell(currentRow, currentCol));
					}
				}
			}
			//Remove the delimeter
			queue.poll();
			
			if(!queue.isEmpty()) {
				queue.add(new Cell(-1, -1));
			}
			
			
		}
	
		return checkAll(a, R, C) ? -1 : count;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[][] = {{2,1,1},
						{1,1,0},
						{0,1,1}};
		
		System.out.println(rotOranges(arr, 3, 3));
		
		

	}

}
