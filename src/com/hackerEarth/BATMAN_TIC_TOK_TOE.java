package com.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BATMAN_TIC_TOK_TOE {

	public static void main(String[] args) {
		try {
			FastReader in = new FastReader();
			int t = in.nextInt();
			while(t-- > 0) {
				char input[][] = new char[4][4];
				for(int i = 0; i < 4; i++) {
					input[i] = in.nextLine().toCharArray();
				}
				boolean flag = false;
				
				//column match
				for(int i = 0; i < 2; i++) {
					for(int j = 0; j < 4; j++) {
						if(input[i][j]=='x'&&input[i+1][j]=='x'&&input[i+2][j]=='.')
		                    flag=true;
		                if(input[i][j]=='x'&&input[i+1][j]=='.'&&input[i+2][j]=='x')
		                    flag=true;
		                if(input[i][j]=='.'&&input[i+1][j]=='x'&&input[i+2][j]=='x')
		                    flag=true;
					}
				}
				
				//row match
				for(int i = 0; i < 4; i++) {
					for(int j = 0; j < 2; j++) {
						if(input[i][j]=='x'&&input[i][j+1]=='x'&&input[i][j+2]=='.')
							flag = true;
						if(input[i][j]=='x'&&input[i][j+1]=='.'&&input[i][j+2]=='x')
							flag = true;
						if(input[i][j]=='.'&&input[i][j+1]=='x'&&input[i][j+2]=='x')
							flag = true;
					}
				}
				
				for(int i = 0; i < 2; i++) {
					for(int j = 0; j < 2; j++) {
						if(input[i][j]=='x'&&input[i+1][j+1]=='x'&&input[i+2][j+2]=='.')
							flag = true;
						if(input[i][j]=='x'&&input[i+1][j+1]=='.'&&input[i+2][j+2]=='x')
							flag = true;
						if(input[i][j]=='.'&&input[i+1][j+1]=='x'&&input[i+2][j+2]=='x')
							flag = true;
					}
				}
				
				for(int i = 0; i < 2 ; i++) {
					for(int j = 3; j >= 2; j--) {
						if(input[i][j]=='x'&&input[i+1][j-1]=='x'&&input[i+2][j-2]=='.')
							flag = true;
						if(input[i][j]=='x'&&input[i+1][j-1]=='.'&&input[i+2][j-2]=='x')
							flag = true;
						if(input[i][j]=='.'&&input[i+1][j-1]=='x'&&input[i+2][j-2]=='x')
							flag = true;
					}
				}
				
				if(flag == true)
					System.out.println("YES");
				else
					System.out.println("NO");
				
				
			}
			
		}catch(Exception e) {
			e.getStackTrace();
		}

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
