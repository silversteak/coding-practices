package com.geeksforgeeks;

public class LUVCY_GAME {

	public static int getMax(int arr[], int n)
	{
		int max = Integer.MIN_VALUE;;
		for (int i = 0; i < n; i++)
			if (arr[i] > max)
				max = arr[i];
		return max;
	}

	// return the sum of the elements in the array
	public static int getSum(int arr[], int n)
	{
		int total = 0;
		for (int i = 0; i < n; i++)
			total += arr[i];
		return total;
	}

	// find minimum required painters for given maxlen
	// which is the maximum length a painter can paint
	public static int numberOfPainters(int arr[], int n, int maxLen)
	{
		int total = 0, numPainters = 1;

		for (int i = 0; i < n; i++) {
			total += arr[i];

			if (total > maxLen) {

				// for next count
				total = arr[i];
				numPainters++;
			}
		}

		return numPainters;
	}

	public static int Min_Time(int arr[], int n, int k)
	{
		int lo = getMax(arr, n);
		int hi = getSum(arr, n);

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int requiredPainters = numberOfPainters(arr, n, mid);

			// find better optimum in lower half
			// here mid is included because we
			// may not get anything better
			if (requiredPainters <= k)
				hi = mid;

			// find better optimum in upper half
			// here mid is excluded because it gives
			// required Painters > k, which is invalid
			else
				lo = mid + 1;
		}

		// required
		return lo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {10 ,20, 30, 40};
		System.out.println(Min_Time(arr,4,2));

	}

}
