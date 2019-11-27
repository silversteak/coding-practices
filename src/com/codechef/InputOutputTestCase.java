package com.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InputOutputTestCase {

	public static void main(String[] args) {
		try {
			int t;
			BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
			t = Integer.parseInt(inp.readLine());
				while(t-->0) {
					String line = inp.readLine();
					String arr[] = line.trim().split("\\s");
					char chartest[] = line.trim().toCharArray();
					int input[] = new int[arr.length];
					for(int i = 0; i < arr.length; i++)
						input[i] = Integer.parseInt(arr[i]);
					String test = inp.readLine();
					char raw[] = test.trim().toCharArray();
					//char input2[] = new char[raw.length];
				}
			// TODO Auto-generated method stub
			}
			catch(Exception e) {}
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

	}

}
