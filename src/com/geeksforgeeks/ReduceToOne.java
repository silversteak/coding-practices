package com.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReduceToOne {
	
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
	
	static int reduce(int n) 
	{ 
	    if (n == 1) 
	        return 0; 
	    else if (n % 2 == 0) 
	        return 1 + reduce(n / 2); 
	    else
	        return 1 + Math.min(reduce(n - 1), 
	                            reduce(n + 1)); 
	} 
	  
	public static void main(String[] args) throws Exception {
		
		FastReader in = new FastReader();
		int t = in.nextInt();
		while(t > 0) {
			System.out.println(reduce(in.nextInt()));
		}
		
	}

}
