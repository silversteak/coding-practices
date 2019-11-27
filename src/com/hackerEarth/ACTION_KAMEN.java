package com.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACTION_KAMEN {
	
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

	public static void main(String[] args) {
		FastReader in = new FastReader();
		int t = in.nextInt();
		while(t-->0){
            long n=in.nextLong();
            long c1=(n*(n-1))/2;
            long c2=(n*(n-1)*(n-2)*(n-3))/24;
            long res=1+c1+c2;
            System.out.println(res);
        }

	}

}
