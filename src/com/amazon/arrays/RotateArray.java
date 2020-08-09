package com.amazon.arrays;

public class RotateArray {
	static int gcd(int a, int b){
		if (b == 0) 
			return a; 
		return gcd(b, a % b);
	}

	static void rotateArr(int arr[], int d, int n){
		int i, j, k;
		for(i = 0; i < gcd(d,n); i++){
			int temp = arr[i];
			k = i;
			while(true){
				j = k + d;
				if(j >= n)
					j = j-n;
				if(j == i)
					break;
				arr[k] = arr[j];
				k = j;
			}
			arr[k] = temp;
		}
	}

}
