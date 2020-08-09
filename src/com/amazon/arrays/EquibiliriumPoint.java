package com.amazon.arrays;

public class EquibiliriumPoint {
	// Function to find equilibrium point
	// a: input array
	// n: size of array
	public static int equilibriumPoint(long arr[], int n) {
		// Your code here
		//long pre[] = new long[n];

		if(n < 2)
			return 1;

		long sum = 0;
		for(int i = 0; i < n; i++)
			sum += arr[i];//pre[i] = pre[i] + arr[i];
		long rightSum = 0, leftSum = 0;    
		for(int i = n-1; i >=0; i--){
			//rightSum +=arr[i];
			sum = sum-arr[i];
			if(rightSum == sum)
				return (i+1);
			rightSum += arr[i];    
		}
		return -1;
	}

}
