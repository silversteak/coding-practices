package com.geeksforgeeks.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

class ArrayNode implements Comparable {
	int array, index , value;

	ArrayNode(int array, int index, int value) {
		this.array = array;
		this.index = index;
		this.value = value;
	}

	public int compareTo(Object o) {
		ArrayNode ab = (ArrayNode) o;
		if (value > ab.value) return 1;
        if (value < ab.value) return -1;
		return 0;
	}

}

public class MergeKSortedArrays {

	public static int[] merge(int [][] input) {
		PriorityQueue<ArrayNode> pq = new PriorityQueue<>();
		int size = 0;
		for(int i = 0; i < input.length; i++) {
			size += input[i].length;
			if(input[i].length > 0)
				pq.add(new ArrayNode(i, 0, input[i][0]));		
		}
		int result[] = new int[size];
		
		ArrayList<Integer> test = new ArrayList<>();
		
		for(int i = 0; !pq.isEmpty() ; i++) {
			ArrayNode an = pq.poll();
			result[i] = an.value;
			test.add(an.value);
			int newIndex = an.index + 1;
			if(newIndex < input[an.array].length)
				pq.add(new ArrayNode(an.array, newIndex,input[an.array][newIndex]));
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		int arr[][] = {{1, 2, 3},

		             {4, 5, 6},

		             {7, 8, 9}};
		
		int result[] = merge(arr);
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < result.length - 1) {
			sb.append(result[i++] + " ");
		}
		
		System.out.println(sb.append(result[i]));

	}
}
