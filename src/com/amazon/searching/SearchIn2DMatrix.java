package com.amazon.searching;

public class SearchIn2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0)
			return false;

		int left = 0, top = 0, bottom = matrix.length - 1, right = matrix[0].length;

		while(left < right && bottom >= top){
			if(matrix[bottom][left] == target) return true;

			if(matrix[bottom][left] < target)
				left++;
			else
				bottom--;

		}

		return false;
	}

}
