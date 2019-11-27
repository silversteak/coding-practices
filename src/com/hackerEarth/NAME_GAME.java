package com.hackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NAME_GAME {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	/*	try {
			int t = Integer.parseInt(br.readLine()); 
			int freq[] = {67,71,73,79,83,89};		
			while(t-- > 0) {
				String input = br.readLine();
				char arr[] = input.toCharArray();
				for(int i = 0; i < arr.length; i++) {
					char temp = arr[i];
					int min = 999999, index = 0;;
					for(int j = freq.length-1; j >= 0; j--) {
						int abs = Math.abs((int)temp-freq[j]);
						if(abs <= min) {
							min = abs;
							index = j;
						}	
					}
					temp = (char) freq[index];
					arr[i] = temp;
				}
				System.out.println(String.copyValueOf(arr));
			}

		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}*/
        
        try {
			int t = Integer.parseInt(br.readLine()); 
			int freq[] = {67,71,73,79,83,89};		
			while(t-- > 0) {
				String input = br.readLine();
				char arr[] = input.toCharArray();
				for(int i = 0; i < arr.length; i++) {
					char temp = arr[i];
					int min = 999999, index = 0;;
					for(int j = freq.length-1; j >= 0; j--) {
						int abs = Math.abs((int)temp-freq[j]);
						if(abs <= min) {
							min = abs;
							index = j;
						}	
					}
					temp = (char) freq[index];
					arr[i] = temp;
				}
				System.out.println(String.copyValueOf(arr));
			}

		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

}
