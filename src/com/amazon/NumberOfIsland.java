package com.amazon;

import java.util.ArrayList;

public class NumberOfIsland {
	
	static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {
	     
        boolean visited[][] = new boolean[N][M];
     
        int count = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(A.get(i).get(j) == 1 && !visited[i][j]){
                    count++;
                    dfs(A, i, j, visited);
                }
            }
        }
        return count;
    }
    
    public static boolean isSafe(int row, int col, int R, int C){
        return (row >= 0 && row < R && col >=0 && col < C);
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> A, int row, int col, boolean visited[][]){
        
        visited[row][col] = true;
        
        int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1},
                        {1,1},{-1,-1},{1,-1},{-1,1}};
                        
        int R = A.size();
        int C = A.get(0).size();
        
        for(int[] dir : dirs){
            int currentRow = row + dir[0];
            int currentCol = col + dir[1];
            if(isSafe(currentRow, currentCol, R, C) && A.get(currentRow).get(currentCol) == 1 
                && !visited[currentRow][currentCol]){
                dfs(A, currentRow, currentCol, visited);        
            }
        }

    }
}
