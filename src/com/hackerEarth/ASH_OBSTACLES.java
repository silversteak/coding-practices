package com.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ASH_OBSTACLES {

	public static void main(String[] args) {
		
		try {
			FastReader in = new FastReader();
			int t = in.nextInt();
			while(t-- > 0) {
				int n = in.nextInt();
				long arr[] = new long[n];
				long tempArr[] = new long[n];
				for(int i = 0; i < n; i++) {
					arr[i] = in.nextLong();
					tempArr[i] = arr[i];
				}

				Arrays.sort(tempArr);
				int count = 1;
				Map <Long, Integer> mymap = new	HashMap<>();
				for(int i = n-1; i >=0 ; i--) {
					if(mymap.containsKey(tempArr[i]))
						count++;
					else {
						mymap.put(tempArr[i], count);
						count++;
					}
						
				}
				
				for(long k : arr) {
					System.out.print(mymap.get(k) + " ");
				}
				
				System.out.println(Arrays.toString(arr));
				
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
