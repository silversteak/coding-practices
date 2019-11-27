package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ISOMORPHIC {
	
	static boolean isomorph(String s1, String s2) {
		
		if(s1.isEmpty() || s1.length() != s2.length() || s1.length() < 1)
			return false;
		
		Map<Character, Character> mymap = new HashMap<>();
		
		for(int i = 0; i < s1.length(); i++) {
			char a = s1.charAt(i);
			char b = s2.charAt(i);
			
			/*if(!mymap.containsKey(a)) {
				mymap.put(a, b);
				if()
					return false;
			}else{
				if(!mymap.get(a).equals(b))
					return false;
			}
			i++;*/
			
			if(mymap.containsKey(a)) {
				if(!mymap.get(a).equals(b))
					return false;
			}else {
				if(!mymap.containsValue(b))
					mymap.put(a, b);
				else
					return false;
			}
			
		i++;	
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		FastReader in = new FastReader();
		String s1 = in.nextLine();
		String s2 = in.nextLine();
			
		System.out.println(isomorph(s1, s2));

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
