package com.amazon.searching;

public class SquareRoot {

	public int mySqrt(int x) {
		int low = 1, high = x;
		int ans = 0;
		while(low <= high){
			int mid = low + (high-low)/2;

			if(mid > x / mid)
				high = mid - 1;
			else{
				//if(mid+1 > x / (mid+1))
					//   return mid;
				ans = mid;
				low = mid + 1;
			}

		}
		return ans; 
	}

}
