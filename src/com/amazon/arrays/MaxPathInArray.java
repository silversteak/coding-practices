package com.amazon.arrays;

public class MaxPathInArray {
	/*You are required to complete this method
	 * ar1 : 1st array
	 * ar2 : 2nd array
	 */
	int maxPathSum(int ar1[], int ar2[])
	{
		int n = ar1.length;
		int m = ar2.length;

		int i = 0, j = 0, sum1 = 0, sum2 = 0, result = 0;

		while(i < n && j < m){

			if(ar1[i] < ar2[j])
				sum1+=ar1[i++];
			else if(ar1[i] > ar2[j])
				sum2+=ar2[j++];
			else{
				result += Math.max(sum1,sum2);
				sum1 = 0;
				sum2 = 0;

				while(i < n && j < m && ar1[i] == ar2[j]){
					result+=ar1[i];
					i++;
					j++;
				}

			}
		}

		while(i < n){
			sum1 += ar1[i++]; 
		}

		while(j < m){
			sum2 += ar2[j++];
		}

		return result + Math.max(sum1,sum2);

		// Your code here
	}

}
