package com.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SKILLENZABINARY {

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
	
	private static void print2Binaryform(BigInteger number) {
	    BigInteger reminder2;
	    if(number.compareTo(BigInteger.ONE)<=0){
	        System.out.print(number);
	        return;
	    }
	    reminder2 = number.mod(new BigInteger(""+2));
	    print2Binaryform(new BigInteger(""+number.divide(new BigInteger("2"))));
	    System.out.print(reminder2);
	}
	
	
	
	public static void main(String[] args) {
		
		FastReader in = new FastReader();
		int t = in.nextInt();
		
		while(t-- > 0) {
			//BigInteger num = new BigInteger(in.nextLine());
			//print2Binaryform(num);
			long dec = Long.parseLong(in.nextLine()); 
			String bin = Long.toBinaryString(dec);
			int countOne = 0, countTwo = 0;
			for(int i = 0; i <= bin.length(); i++) {
				for(int j = i+1; j <= bin.length(); j++) {
					String str = bin.substring(i, j);
					System.out.println(str);
				}
			}
			//System.out.println(countOne + " " + countTwo);
			
			
		}
		

	}

}
