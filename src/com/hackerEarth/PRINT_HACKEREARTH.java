package com.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PRINT_HACKEREARTH {

	public static void main(String[] args) {
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
		try {
			t = Integer.parseInt(br.readLine());
	        
			while(t -- > 0 ){
	            String input = br.readLine();
	            Map<Character, Integer> mymap = new HashMap<>();
	            for(int i = 0; i < input.length(); i++) {
	            	if(!mymap.containsKey(input.charAt(i)))
	            		mymap.put(input.charAt(i), 1);
	            	else
	            		mymap.put(input.charAt(i), (mymap.get(input.charAt(i)))+1);
	            }
	            
	            mymap.put('h', (mymap.get('h'))/2) ;
	            mymap.put('a', (mymap.get('a'))/2);
	            mymap.put('e', (mymap.get('e'))/2);
	            mymap.put('r', (mymap.get('r'))/2);
	            
	            int ans = mymap.get('h'); 
	            
	            /*mymap.forEach((eachChar, eachCount) -> {
	            	ans = 0;
	            	if(ans > eachCount)
	            		ans = eachCount;
	            });*/
	            
	            for(Map.Entry<Character, Integer> entry : mymap.entrySet()) {
	            	int temp = entry.getValue();
	            	if(ans > temp)
	            		ans = temp;
	            }
	            System.out.println(ans);
	            
	        }   
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        

            
        }           

	}


