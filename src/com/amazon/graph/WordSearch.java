package com.amazon.graph;

public class WordSearch {

	/*
	 * 4 4
q t x p
o m d u
e y s y
m y i f
yifydsy

failing fr this test case
	 * 
	 * */
	
	
	public static boolean isSafe(int row, int col, int R, int C){
        return (row >= 0 && row < R && col >=0 && col < C);
    }
    
    public static boolean dfs(char[][] board, String word,int i, int j, int level){
        
        if(board[i][j] != word.charAt(level))
            return false;
        
        if(level >= word.length()-1)
            return true;
        
        char temp = board[i][j];
        board[i][j] = '#';
        
        int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1},
                        {1,1},{-1,-1},{1,-1},{-1,1}};
                        
        int R = board.length;
        int C = board[0].length;
        
        boolean flag = false;
        
        for(int[] dir : dirs){
            int currentRow = i + dir[0];
            int currentCol = j + dir[1];
            if(isSafe(currentRow, currentCol, R, C)
                && board[currentRow][currentCol] == word.charAt(level+1)){
                if(dfs(board, word, currentRow, currentCol, level+1))
                    return true;
                }
        }
        
        board[i][j] = temp;
        
        return false;
    }
    
    public int wordSearch(char[][] board, String word){
        
        int level = 0;
        boolean flag = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, word, i, j, level))
                    return 1;
                
            }
        }
        
        return 0;
        
    }
}
