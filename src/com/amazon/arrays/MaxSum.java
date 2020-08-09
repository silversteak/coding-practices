package com.amazon.arrays;

public class MaxSum {

	int max_sum(int A[], int n){

		int arrSum = 0;
		int currVal = 0;
		for(int i = 0; i < n; i++){
			arrSum += A[i];
			currVal += (i*A[i]);
		}

		int ans = currVal;

		for(int i = 1; i < n; i++){
			currVal = currVal + arrSum - n * A[n-i];
			if(currVal > ans)
				ans = currVal;
		}

		return ans;    

	}	

}
