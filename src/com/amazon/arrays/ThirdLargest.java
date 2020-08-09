package com.amazon.arrays;

public class ThirdLargest {

	int thirdLargest(int a[], int n)
	{
		if(n < 3)
			return -1;

		int first, second, third;
		first = second = third = a[0];

		for(int i = 1; i < n; i++){
			if(a[i] > first){
				third = second;
				second = first;
				first = a[i];
			}
			else if(a[i] > second){
				third = second;
				second = a[i];
			}else if(a[i] > third){
				third = a[i];
			}
		}
		return third;
	}

}
