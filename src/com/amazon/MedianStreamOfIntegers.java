package com.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianStreamOfIntegers {

	public static double [] runningMedian(int[] nums) {

		int n = nums.length;
		PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		PriorityQueue<Integer> highers = new PriorityQueue<>();

		double[] medians = new double[n];


		for(int i = 0; i < n; i++) {
			int number = nums[i];
			addNumber(number, lowers, highers);
			rebalance(lowers, highers);
			medians[i] = getMedian(lowers, highers);
		}
		return medians;
	}


	private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
		
		if(biggerHeap.size() == smallerHeap.size()) {
			return (double)(biggerHeap.peek()+smallerHeap.peek())/2;
		}else {
			return (double)biggerHeap.peek();
		}
	}


	private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
		
		if(biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}
		
	}


	private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if(lowers.size() == 0 || lowers.peek() > number)
			lowers.add(number);
		else
			highers.add(number);
	}


	public static void main(String[] args) {

		

	}

}
