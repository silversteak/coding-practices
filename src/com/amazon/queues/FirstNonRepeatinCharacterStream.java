package com.amazon.queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNonRepeatinCharacterStream {
	
	public static List<Character> firstNonRepeatChar(char stream[]){
		List<Character> ans = new ArrayList<>();
		
		Queue<Character> queue = new LinkedList<>();
		int freq[] = new int[26];
		for(char ch : stream) {
			queue.add(ch);
			freq[ch - 'a']++;
			
			while(!queue.isEmpty()) {
				if(freq[queue.peek() - 'a'] > 1) {
					queue.poll();
				}else {
					ans.add(queue.peek());
					break;
				}
			}
			
			if(queue.isEmpty()) {
				ans.add('1');
			}
			
		}
		return ans;
	}
	
	public static void main(String args[]) {
		String str1 = "aabbcd";
		List<Character> ans = firstNonRepeatChar(str1.toCharArray());
		System.out.println(ans);
	}

}
