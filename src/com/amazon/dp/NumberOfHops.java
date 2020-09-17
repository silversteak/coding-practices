package com.amazon.dp;

import java.util.Arrays;

public class NumberOfHops {

	static long countWays(int n)
	{
		// add your code here
		long count[] = new long[n+1];
		Arrays.fill(count, -1);
		return printCountRec(n, count);
	}

	static long printCountRec(int dist, long count[]) 
	{ 
		if(count[dist] != -1)
			return count[dist];

		// Base cases 
		if (dist<0)     
			return 0; 
		if (dist==0 || dist == 1)     
			return 1;
		if(dist == 2)
			return 2;

		// Recur for all previous 3 and add the results 
		count[dist] = (printCountRec(dist-1, count) +  
				printCountRec(dist-2, count) + 
				printCountRec(dist-3, count)) % 1000000007;

		return count[dist];       
	} 

}
