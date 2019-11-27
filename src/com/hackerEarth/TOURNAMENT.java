package com.hackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TOURNAMENT {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine()); 
			while(t-- > 0) {
				int n = Integer.parseInt(br.readLine());
				String input1 = br.readLine();
				String input2 = br.readLine();
				int count = 0;
				Map<Character, Integer> mymap1 = new HashMap<>();
				for(int i = 0; i < input1.length(); i++) {
	            	if(!mymap1.containsKey(input1.charAt(i)))
	            		mymap1.put(input1.charAt(i), 1);
	            	else
	            		mymap1.put(input1.charAt(i), (mymap1.get(input1.charAt(i)))+1);
	            }
				for(int i = 0; i < input2.length(); i++) {
	            	if(mymap1.containsKey(input2.charAt(i))) {
	            		int temp = mymap1.get(input2.charAt(i));
	            		if(temp != 0) {
	            			mymap1.put(input2.charAt(i), temp-1);
	            			count++;
	            		}
	            	}
	            }
				
				System.out.println(count);
				
				}
			
			}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

}
