package com.leetcode;

public class ApplicationBS {

	public static int search(int[] nums, int target, boolean flag) {

		int n = nums.length;

		int result = -1;

		int low = 0, high = n - 1; 

		while(low <= high) {

			// calculate mid
			int mid =  low + ((high - low)/2);

			// if the mid is the target
			if(nums[mid] == target) {
				//1. go left
				//2. go right
				result = mid;
				if(flag) high = mid - 1;
				else low = mid + 1;
			}

			else if (nums[mid] < target) {
				low = mid + 1;
			}else if (nums[mid] > target) {
				high = mid - 1;
			}

		}

		return result;
	}	

	public static int[] searchRange(int[] nums, int target) {

		int result[] = {-1,-1};

		if(nums.length == 0)
			return result;

		int left = search(nums, 7, true);
		int right = search(nums, 7, false);

		result[0] = left;
		result[1] = right;

		return result;

	}

	public static int pow(int n, int x) {
		if(n == 0)
			return 1;
		else if( n % 2 == 0) {
			int temp = pow(n/2, x);
			return temp * temp;
		}else
			return x * pow((n-1), x);
	
	}
	
	public static double myPowFinal(double x, int n) {
        
		if(n == 0)
			return 1.0;
		else if( n % 2 == 0) {
			double temp = 0.0;
			try {
				temp = myPowFinal(x,n/2);
			}catch(Exception e) {
				System.out.println("the value of n" + n + " temp " + temp);
			}
			return temp*temp;
		}
		return x * myPowFinal(x,n-1);
		
    }
	
	public static double myPow(double x, int n) {
		
		boolean flag = false;
		
		if(n < 0) {
			flag = true;
			n = -1 * n;
		}
		
		if(flag)
			return 1 / myPowFinal(x, n);	
		
		return myPowFinal(x, n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		int arr[] = {2,4,4,4,4,4,4,7,7,8};

		int left = search(arr, 7, true);
		int right = search(arr, 7, false);

		System.out.println(left + "   " + right);*/

		System.out.println(myPow(1,-2147483648));
		

	}

}
