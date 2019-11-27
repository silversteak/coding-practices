package com.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class COLORTHEBOX {
	
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

	 public static long factorial(int n) {
	        //1
	        long fact = 1;
	        //2
	        for (int i = 1; i <= n; i++) {
	            //3
	            fact = (fact * i) % 1000000007;
	        }
	        //4
	        return fact;
	  }
	 
	 public static long ans(int n) {
		 
		 long count = 0;
		 
		 for(int len = 1; len <= n; len++) {
			 
			 for(int start = 1; start <= n - len + 1; start++) {
				 
				 int end = start + len - 1;
				 for(int i = start; i <= end; i = i+2) {
					 System.out.print(i + " ");
					 count++;					 
				 }
			 }
			 
			 System.out.println();
		 }
		 
		 return count;
	 }
	 

	public static void main(String[] args) {
		
		try {
			// TODO Auto-generated method stub
			FastReader in = new FastReader();
			int n = in.nextInt();
			
			System.out.println(ans(n));
			
		} catch (Exception e) {
		}

	}

}
