package com.amazon.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MatchSpecificPatterns {
	public static String createHash(String word){

		Map<Character, Integer> map = new HashMap<>();
		int i = 0;
		String res = "";
		for(char ch : word.toCharArray()){
			if(!map.containsKey(ch)) map.put(ch, i++);
			res = res+map.get(ch);
		}
		return res;

	}
	public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern){

		String hash = createHash(pattern);
		ArrayList<String> ans = new ArrayList<>();
		for(String word : dict){
			if(createHash(word).equals(hash))
				ans.add(word);
		}

		return ans;
	}
}
