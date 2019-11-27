package com.codechef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class CHDIGER {

	static int countDigits(long n) {
		int count = 0; 
		while (n != 0) { 
			n = n / 10; 
			++count; 
		} 
		return count; 
	}

	static long appendZeros(long input) {
		int n = countDigits(input);
		long output = 1;
		for(int i = 1; i < n; i++)
			output = output * 10;
		return output;
	}

	static long replaceDigits(long input, long place, long rep) {
		input = input % place;
		input = input * 10 +rep;
		return input;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		try {
			Scanner sc  = new Scanner(System.in);
			t = sc.nextInt();
			while(t-- > 0){
				long num, rep, min_so_far;
				num = sc.nextLong();
				rep = sc.nextLong();
				//int digit = countDigits(num);
				//count = appendZeros(num);
				//countLess = count/10;
				long result = 0;
				ArrayList<Long> array = new ArrayList<Long>();
				do{
					array.add(num % 10);
					num/= 10;
				} while  (num > 0);
				
				Collections.reverse(array);
				int countA = 0;
				
				min_so_far = rep;
				
				for(int i = array.size()-1; i >= 0; i-- ) {
					if(array.get(i) > min_so_far) {
						array.remove(i);
						array.add(rep);
					}	
					else if(array.get(i) < min_so_far) {
						min_so_far = array.get(i);
					}
				}
				Collections.reverse(array);
				int size = array.size();
				long sum = 0;
				for(int i = 0; i < size;i++) {
					long temp = array.get(size-i-1);
					array.remove(size-i-1);
					sum = sum * 10 + temp;
				}
				
				System.out.println(sum);
				
				
				


				System.out.println(result);


			}


		}
		catch(Exception e) {}
	}
}