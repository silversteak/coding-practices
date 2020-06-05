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
		
		String j = "agsdha";
		StringBuffer br = new StringBuffer(j);
		
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
	
	public boolean check(String n){
        StringBuffer br = new StringBuffer(n);
         boolean test = br.equals(br.reverse()) ? true : false;
         System.out.println(test);
         return test;
    }
    
    public void magicNumbers(int n)
    {
        Queue<String> queue = new LinkedList<>();
		queue.add("4");
		queue.add("5");
		
		/*for(int i = 0; i < n; i++) {
			String temp = queue.poll();
			result.add(temp);
			queue.add(temp+"4");
			queue.add(temp+"5");
		}*/
		int i = 0;
		while(!queue.isEmpty() && i < n){
		    String temp = queue.poll();
			if(check((temp)) == true){
			    System.out.println(temp);
			    i++;
			}
			if(i == n)
			    break;
			queue.add(temp+"4");
			queue.add(temp+"5");    
		}
		
		/*while(!queue.isEmpty()) {
			result.add(queue.poll());
		}*/
        
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		increaseNumber(10);

	}

}
