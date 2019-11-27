package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CamelCase {

	public static void main(String[] args) {
		FastReader in = new FastReader();
		int t = in.nextInt();
		while(t-- >= 0) {
			char str[] = in.nextLine().toCharArray();
			for(int i = 0; i < str.length;i++) {
				if(str[i]=='_')
					str[i+1] = (char) (str[i+1] - 32);
			}
			String k = String.copyValueOf(str);
			k = k.replaceAll("_", "");
			System.out.println(k);
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
