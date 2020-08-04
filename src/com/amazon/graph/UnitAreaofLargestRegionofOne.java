package com.amazon.graph;

public class UnitAreaofLargestRegionofOne {

	static int findMaxArea(int N, int M, int A[][]) {
        boolean visited[][] = new boolean[N][M];
        int area = 0;
        int ans = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(A[i][j] == 1 && !visited[i][j]){
                    area = dfs(A, visited, i, j);
                    ans = Math.max(area, ans);
                }
            }
        }
        
        return ans;
    }
    
    public static boolean isSafe(int row, int col, int R, int C){
        return (row >= 0 && row < R && col >=0 && col < C);
    }
    
    public static int dfs(int A[][], boolean visited[][], int row, int col){
        visited[row][col] = true;
        int count = 1;
        
        int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1},
                        {1,1},{-1,-1},{1,-1},{-1,1}};
        
        int R = A.length;
        int C = A[0].length;
        
        for(int[] dir : dirs){
            int currentRow = row + dir[0];
            int currentCol = col + dir[1];
            if(isSafe(currentRow, currentCol, R, C) && A[currentRow][currentCol] == 1 
                && !visited[currentRow][currentCol]){
                count += dfs(A, visited, currentRow, currentCol);        
            }
        }
                        
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
