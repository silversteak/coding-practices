package com.leetcode;

import java.util.Arrays;

public class Complement {


	public static int bitwiseComplement(int N) {
		int res = 0, num = N;
		int i = 0;

		if(N == 0) return 1;

		while (num > 0){

			if((num&1)==0){
				System.out.println("Before Addition" + res);
				System.out.println("1 << i" + (1 << i));
				res+=(1 << i);
				System.out.println("After Addition" + res);
			}
			i++;
			num = num>>1;    
				System.out.println("Decress the number " + num);    
		}
		return res;
	}

	public static void main(String args[]) {
		System.out.println(bitwiseComplement(5));
		//printArrays();
	}
}

