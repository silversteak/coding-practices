package com.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SPLIT_HOUSE {

	public static void main(String[] args) {
		try {
			FastReader in = new FastReader();
			int n = in.nextInt();
			String str = in.nextLine();
			boolean flag = true;
			for(int i = 0; i < n-1; i++) {
				if(str.charAt(i) == 'H' && str.charAt(i+1) == 'H') {
					System.out.println("NO");
					flag = false;
					break;
				}
			}
			
			if(flag) {
				System.out.println("YES");
				System.out.println(str.replaceAll("\\.", "B"));
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
