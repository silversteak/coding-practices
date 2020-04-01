package com.gfg.stacks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueNumberCreation {
	
	public static void increaseNumber(int n) {
		Queue<String> queue = new LinkedList<>();
		List<String> result = new ArrayList<>();
		queue.add("5");
		queue.add("6");
		
		for(int i = 0; i < n; i++) {
			String temp = queue.poll();
			result.add(temp);
			queue.add(temp+"5");
			queue.add(temp+"6");
		}
		
		while(!queue.isEmpty()) {
			result.add(queue.poll());
		}
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		increaseNumber(10);

	}

}
