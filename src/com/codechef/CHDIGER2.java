package com.codechef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class CHDIGER2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		try {
			Scanner sc = new Scanner(System.in);
			t = sc.nextInt(); 
			while (t-- > 0) {
				long number, value,result = 0;
				ArrayList<Long> inputArray = new ArrayList<Long>();
				ArrayList<Long> sortedArray = new ArrayList<Long>();
				ArrayList<Long> outputArr = new ArrayList<Long>();
				
				number = sc.nextLong();
				value = sc.nextLong();

				do {
					inputArray.add(number % 10);
					number /= 10;
				} while (number > 0);

				Collections.reverse(inputArray);
				int originalSize = inputArray.size();

				for (Iterator<Long> itr = inputArray.iterator(); itr.hasNext();) {
					if (itr.next().longValue() >= value)
						itr.remove();

				}

				sortedArray.addAll(inputArray);
				int arraySize = inputArray.size();
				int currIndex = 0, count = 0;
				Collections.sort(sortedArray);

				for (int i = 0; i < arraySize; i++) {
					for (int j = currIndex; j < arraySize; j++) {
						if (inputArray.get(j) == sortedArray.get(i)) {
							currIndex = j + 1;
							outputArr.add(sortedArray.get(i));
							break;
						}
					}
				}
				count = outputArr.size();
				result = 0;
				for (int i = 0; i < originalSize; i++) {
					if (i < count) {
						result = result * 10 + outputArr.get(i);
					} else {
						result = result * 10 + value;
					}
				}
				System.out.println(result);
			}
		} catch (Exception e) {}

	}

}
