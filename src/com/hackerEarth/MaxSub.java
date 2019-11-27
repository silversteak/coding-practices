package com.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxSub {
	
	/*int incl = arr[0]; 
	  int excl = 0; 
	  int excl_new; 
	  int i; 
	  
	  for (i = 1; i < n; i++) 
	  { 
	      current max excluding i 
	     excl_new = (incl > excl)? incl: excl; 
	  
	      current max including i 
	     incl = excl + arr[i]; 
	     excl = excl_new; 
	  } 
	  
	    return max of incl and excl 
	   return ((incl > excl)? incl : excl); 
	*/
	
	public static int maxSumSubseq(int[] nums){
		
		int len = nums.length;
        
        if(len == 0)
            return 0;
        
        if(len == 1)
            return nums[0];
        
        if(len == 2)
            return Math.max(nums[0], nums[1]);
        
        int dp[] = new int[len];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],dp[0]);
        
        for( int i = 2; i < len; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        
        
        return dp[len-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FastReader in = new FastReader();
			int t = in.nextInt();
			while(t-- > 0) {
				int n = in.nextInt();
				int arr[] = new int[n];
				for(int i = 0; i < n; i++)
					arr[i] = in.nextInt();
				
				System.out.println(maxSumSubseq(arr));
			}
			
		}catch(Exception e) {
			
		}
		
		
	}
	
	static class FastReader{ 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader(){ 
			br = new BufferedReader(new InputStreamReader(System.in)); 
		} 

		String next() { 
			while (st == null || !st.hasMoreElements()){ 
				try{ 
					st = new StringTokenizer(br.readLine()); 
				}catch (IOException  e){ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() { 
			return Integer.parseInt(next()); 
		} 

		long nextLong(){ 
			return Long.parseLong(next()); 
		} 

		double nextDouble(){ 
			return Double.parseDouble(next()); 
		} 

		String nextLine(){ 
			String str = ""; 
			try{ 
				str = br.readLine(); 
			} 
			catch (IOException e) { 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	} 

}
