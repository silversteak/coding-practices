package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


//tree

//eert




public class SortByFreqency {
	
	
	public static String sortFrequencyTest(String s) {
		Map<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        
       
        Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                stringBuilder.append(entry.getKey());
            }
        }
        return stringBuilder.toString();
	}

	public static String sortFrequency(String s) {
		if(s == null || s.length() == 0)
			return "";
		
		HashMap<Character, Integer> mymap = new HashMap<>();
		
		for(char ch : s.toCharArray()){
			mymap.put(ch, mymap.getOrDefault(ch, 0) + 1);
		}
		
		PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> mymap.get(b).compareTo(mymap.get(a)));
		
		pq.addAll(mymap.keySet());
		
		StringBuffer sb = new StringBuffer();
		
		while(!pq.isEmpty()) {
			char ch = pq.poll();
			for(int i = 0; i < mymap.get(ch); i++)
				sb.append(ch);
		}
		return new String(sb);
	}
	
	public static void main(String[] args) {
		
		String ab = "ccccccbbaaaa";
		
		System.out.println(sortFrequency(ab));
		
		System.out.println(sortFrequencyTest(ab));
		
	}

}
