package com.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class PerfectSquare {
	
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
	
	static boolean isPerfectSquare(long n) {
		double temp = Math.sqrt(n);
		if(temp - Math.round(temp) != 0)
			return false;
		return true;
	}
	
	//close
	
	
	static boolean rotateString(String A, String B) {
		if(A.length()!=B.length())
			return false;
		A = A + A;
		if(A.indexOf(B,0) != -1)
			return true;
		return false;
	}
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//FastReader in = new FastReader();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
		
			long value = Long.parseLong(br.readLine());
			
				long up = 0, down = 0, perfectUp = 0, perfectDown = 0;
				
				//for the above N
				up = value+1;
				while(true) {
					if(isPerfectSquare(up)) {
						perfectUp = up;
						break;
					}
					else
						up++;
				}
				
				// for below the N
				down = value - 1;
				while(true) {
					if(isPerfectSquare(down)) {
						perfectDown = down;
						break;
					}
					else
						down--;
				}
				
				if(Math.abs(value - perfectUp) <= Math.abs(value - perfectDown))
					System.out.println(perfectUp);
				else
					System.out.println(perfectDown);
	
			}
				
		}
		
		
	}

