package com.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class GetTheShadow {
	
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
				}catch (IOException e){ 
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
		// TODO Auto-generated method stub
		
		FastReader in = new FastReader();
		int t = in.nextInt();
		while(t-- > 0) {
			int n = in.nextInt();
			int arr[] = new int[n+1];
			for(int i = 1; i <= n;i++)
				arr[i] = in.nextInt();
			
			for(int i = 1; i <=n; i++) {
				int abs = Math.abs(arr[i]);
				if(arr[abs]>0)
					arr[abs] = -arr[abs];
				else
					System.out.print(abs);
			}
			
			for(int i = 1; i <=n; i++) {
				//int abs = Math.abs(arr[i]);
				if(arr[i]>0)
					System.out.print(" "+i);
			}
			
			System.out.println();
		}
		
		

	}

}
