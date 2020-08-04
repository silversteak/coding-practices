package com.amazon.graph;

public class FindThePath {

	public static int is_possible(int M[][], int N) {

		boolean visited[][] = new boolean[N][N];

		int flag = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(M[i][j] == 1 && !visited[i][j]){
					if(dfs(M, N, i, j, visited)){
						flag = 1;
						break;
					}
				}
			}
		}
		return flag;
	}

	public static boolean isSafe(int N, int row, int col){
		return row >=0 && row < N && col >=0 && col < N;
	}

	public static boolean dfs(int M[][], int N, int row, int col, boolean visited[][]){

		if(isSafe(N, row, col) && !visited[row][col] && M[row][col] != 0){
			visited[row][col] = true;

			if(M[row][col] == 2)
				return true;

			return  dfs(M, N, row+1, col, visited) || 
					dfs(M, N, row-1, col, visited) ||
					dfs(M, N, row, col+1, visited) || 
					dfs(M, N, row,col-1, visited);

		}

		return false;

	}
}
