package com.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DPS {
	public static void main(String[] args) {
		try {
		FastReader in = new FastReader();
		int t = in.nextInt();
		while(t-- > 0) {
			String input = in.nextLine();
			int arr[] = new int[26];
			int count = 0;
			for(int i = 0; i < input.length();i++) {
				arr[input.charAt(i)-'a']++;
			}
			for(int k : arr)if(k%2==1)count++;
			
			if(input.length()%2==0) {
				if(count==2)
					System.out.println("DPS");
				else
					System.out.println("!DPS");
			}else {
				if(count == 1 || count == 3)
					System.out.println("DPS");
				else
					System.out.println("!DPS");
			}
				
		}
		}catch(Exception e) {}	

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
