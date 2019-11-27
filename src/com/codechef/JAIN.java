package com.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class JAIN {

	public static void main(String[] args) {
		try {
			int t;
			BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
			t = Integer.parseInt(inp.readLine());
			while(t-->0) {
				int size = Integer.parseInt(inp.readLine());
				long temp[] = new long[32];
				for(int i = 0; i< size; i++){
					String str = inp.readLine();
					int mask = 0;
					for(int j = 0; j< str.length(); j++){
						if(str.charAt(j)=='a')
							mask |= 1;
						if(str.charAt(j)=='e')
							mask |= 2;
						if(str.charAt(j)=='i')
							mask |= 4;
						if(str.charAt(j)=='o')
							mask |= 8;
						if(str.charAt(j)=='u')
							mask |= 16;
					}
					temp[mask]++;
				}

				long ans = (temp[31]*(temp[31]-1))/2;

				for(int i = 0; i < 32; i++) {
					for(int j = i+1; j < 32; j++) {
						if((i|j) == 31)
							ans += temp[i]*temp[j];
					}
				}

				System.out.println(ans);

			}	
			// TODO Auto-generated method stub
		}
		catch(Exception e) {}

	}

}
