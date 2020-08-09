package com.amazon.arrays;

public class MinDist {
	int minDist(int a[], int n, int x, int y) {
		int min = Integer.MAX_VALUE, p = -1;

		for(int i = 0; i < n; i++){

			if(a[i] == x || a[i] == y){
				if(p != -1 && a[p] != a[i])
					min = Math.min(min, i - p);
				p = i;    
			}
		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}

}
