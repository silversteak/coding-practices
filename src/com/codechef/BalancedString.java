package com.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class BalancedString {

	public static void main(String[] args) {
		try {
			int t;
			BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
			t = Integer.parseInt(inp.readLine());
				while(t>0) {
					String input = inp.readLine();
					//int len = input.length();
					Integer freq[] = new Integer[26];
					Arrays.fill(freq, 0);
					
					for(int i = 0; i < input.length();i++)
						freq[input.charAt(i)-'A']++;
					//Collections.sort(freq, Collections.reverseOrder());
					Arrays.sort(freq);
					int sum = 999999;
					Integer test[] = new Integer[26];
					Arrays.fill(test, 99999);
					for(int i = 1; i <=26; i++) {
						if(input.length()%i != 0)
							continue;
						else {
							int distint = input.length()/i;
							int l = 25;
							while(l >= (26-i)){
								//sum = Math.min(sum,freq[l]+Math.abs(freq[l]-distint));
									test[26-i] = Math.max(freq[l],Math.abs(distint-freq[l]));
							l--;
							}
						}
					
					}
					Arrays.sort(test);
					System.out.println(test[0]);
					
					
					t--;
				}
			// TODO Auto-generated method stub
			}
			catch(Exception e) {}
		// TODO Auto-generated method stub

	}

}
