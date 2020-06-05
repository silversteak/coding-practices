package com.geeksforgeeks;

import java.util.Arrays;
import java.util.Comparator;

public class SortWordLexi {
	
	static int index[] = new int[26];
	
	public static String[] sortByOrder(String[] words, String alphabets )
    {
		for(int i = 0; i < alphabets.length(); i++) {
			index[alphabets.charAt(i) - 'a'] = i;
		}
		
		Arrays.sort(words, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				for(int i = 0; i < o1.length() && i < o2.length(); i++) {
					if(o1.charAt(i) == o2.charAt(i))
						continue;
					return index[o1.charAt(i)-'a'] - index[o2.charAt(i)-'a'];
				}
				
				return o1.length() - o2.length();
			}
			
		});
		return words;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String alpha = "qwerty";
		String words[] = {"we", "qwer", "erer", "qw", "errr"};
		
		String test[] = sortByOrder(words, alpha);
		
		System.out.println(Arrays.toString(test));
		
		
		
		

	}

}
