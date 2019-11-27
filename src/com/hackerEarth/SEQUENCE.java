package com.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SEQUENCE {

	public static void main(String[] args) {
		try {
			FastReader in = new FastReader();
			long a = in.nextLong(), b = in.nextLong();
			long f[] = new long[2147483647];
			f[0] = (int)a;
			f[1] = (int)b;
			for(int i = 2; i < 2147483647;i++) {
				f[i] = f[i-2] + f[i-1];
			}
			
			int q = in.nextInt();
			while(q-- > 0) {
				int temp = in.nextInt();
				int isPresent = Arrays.binarySearch(f, temp);
				if(isPresent >= 0) {
					System.out.println("YES");
				}else
					System.out.println("NO");
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
