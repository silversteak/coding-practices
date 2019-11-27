package com.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class CodeChef1 {
	
	public static void main(String[] args) {
		int t;
		try {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(inp.readLine());
		while(t > 0){
			int j = Integer.parseInt(inp.readLine());
			String input[] = new String[j];  
				for(int i = 0; i < j ; i++)
					input[i] = inp.readLine();
					
					Boolean prim[] = new Boolean[26];
					Arrays.fill(prim, new Boolean(true));
					
					for(int i = 0; i < j; i++) {
						Boolean sec[] = new Boolean[26];
						Arrays.fill(sec, new Boolean(false));
						
							for(int k = 0; k < input[i].length(); k++) {
								if(prim[input[i].charAt(k)-'a'])
									sec[input[i].charAt(k)-'a'] = true;
							}
							
							System.arraycopy(sec, 0, prim, 0, 26);
							
					}
				int count = 0;	
				for(int i = 0; i < 26;i++) {
					if(prim[i])
						count++;
				}
				
				System.out.println(count);
				
		t--;
		}
		}
		catch(Exception e) {
			
		}
	}
}
