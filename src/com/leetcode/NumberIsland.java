package com.leetcode;

public class NumberIsland {
	
	public static int numIslands(char grid[][]) {
		if(grid == null || grid.length==0||grid[0].length==0)
			return 0;
		int result = 0;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0 ; j < grid[0].length; j++) {
				if(grid[i][j] == '1') {
					result++;
					dfs(grid, i, j);
				}
			}
		}
		return result;
	}
	
	private static void dfs(char[][] grid, int i, int j) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
			return;
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
	}
	
	
	public static int maxAreaIsland(char grid[][]) {
		if(grid == null || grid.length==0||grid[0].length==0)
			return 0;
		int result = 0;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0 ; j < grid[0].length; j++) {
				if(grid[i][j] == '1') {
					int size = getMaxRegion(grid, i, j);
					result = Math.max(size, result);
				}
			}
		}
		return result;
	}
	

	private static int getMaxRegion(char[][] grid, int i, int j) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
			return 0;
		grid[i][j] = '0';
		int count = 1;
		for(int row = i - 1; row <= i+1; row++) {
			for(int col = j - 1; col <= j + 1; col++) {
				if(row == i - 1 && col == j)
					count += getMaxRegion(grid, row, col);
				if(row == i + 1 && col == j)
					count += getMaxRegion(grid, row, col);
				if(row == i && col == j - 1)
					count += getMaxRegion(grid, row, col);
				if(row == i && col == j + 1)
					count += getMaxRegion(grid, row, col);
			}
		}
		
		
		return count;
	}

	public static void main(String[] args) {
		

	}

}
