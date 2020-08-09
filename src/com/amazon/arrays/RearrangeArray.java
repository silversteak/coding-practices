package com.amazon.arrays;

public class RearrangeArray {

	static void arrange(long arr[], int n)
	{
		for(int i = 0; i < n; i++){
			arr[i] += (arr[(int)arr[i]]%n)*n;
		}

		for(int i = 0; i < n;i++){
			arr[i] = arr[i]/n;
		}

		// your code here
	}

}
