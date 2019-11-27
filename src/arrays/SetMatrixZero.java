package arrays;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int matrix[][] = {{0,1,2,0},
		                  {3,4,5,2},
		                  {1,3,1,5}};
		int R = matrix.length;
		int C = matrix[0].length;
		int dummy = -99990;
		
		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> cols = new HashSet<Integer>();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++ ) {
				if(matrix[i][j]==0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++ ) {
				if(rows.contains(i) || cols.contains(j))
					matrix[i][j] = 0;
			}
		}	
		
		
		/*for(int i = 0; i < rows ; i++) {
			for(int j = 0; j < cols; j++) {
				if(matrix[i][j] == 0) {
					for(int k = 0; k < cols; k++) {
						if(matrix[i][k] != 0)
							matrix[i][k] = dummy;
					}
					
					for(int k = 0; k < rows; k++) {
						if(matrix[k][j] != 0)
							matrix[k][j] = dummy;
					}
				}
			}
		}
		
		
		for(int i = 0; i < rows ; i++) {
			for(int j = 0; j < cols; j++) {
				if(matrix[i][j] == 0 || matrix[i][j] == dummy)
					matrix[i][j] = 0;
				System.out.print(matrix[i][j]);	
				}
				System.out.println();
			}
*/				

	}

}
