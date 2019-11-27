package com.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChefChar {
	
	public static boolean check(char a, char b, char c, char d) {
		char ch[] = {a,b,c,d};
		Arrays.sort(ch);
		if(ch[0] == 'c' && ch[1] == 'e' && ch[2] == 'f' && ch[3] == 'h')
			return true;
		return false;
	}

	public static void main(String[] args) {
		try {
		int t;
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(inp.readLine());
			while(t>0) {
				String input = inp.readLine();
				int len = input.length();
				boolean istrue = false;
				int count = 0;
				for(int i = 0; i < len-3; i++) {
						istrue = check(input.charAt(i), input.charAt(i+1), input.charAt(i+2), input.charAt(i+3));
						if(istrue)
							count++;
				}
				if(count > 0)
					System.out.println("lovely " + count);
				else
					System.out.println("normal");
				t--;
			}
		// TODO Auto-generated method stub
		}
		catch(Exception e) {}
	}

}
