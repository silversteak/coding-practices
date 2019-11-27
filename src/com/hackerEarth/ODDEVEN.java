package com.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ODDEVEN {

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
		int n = in.nextInt();
		int arr[] = new int[n+1];
		
		Map<Integer, Integer> mydp = new HashMap<>();
		
		for(int i = 1; i <= n; i++) {
			long temp = in.nextLong();
			arr[i] = (temp%2 == 0) ? 1 : -1;
		}
		
		int sum = 0;
		int count = 0;
		
		for(int i = 1; i <= n; i++) {
			sum = sum + arr[i];
			if(sum == 0)
				count++;
			if(mydp.containsKey(sum))
				count = count + mydp.get(sum);
			if(!mydp.containsKey(sum))
				mydp.put(sum, 1);
			else {
				int k = mydp.get(sum);
				mydp.put(sum, k+1);
			}
			
		}
		
		System.out.println(count);
		
		

	}

}
