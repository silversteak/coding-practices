package com.amazon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public int wordLadderLength(String start, String target, Set<String> dictionary) {

		if(!dictionary.contains(target))
			return -1;
		
		Queue<String> queue = new LinkedList<>();
		
		queue.add(start);
		int level = 1;
		
		while(!queue.isEmpty()) {
			
			//Loop around the queue
			for(int i = 0; i < queue.size(); i++) {
				
				String currentWord = queue.poll();
				char [] currentWordChar = currentWord.toCharArray();
				
				for(int j = 0; j < currentWordChar.length; j++) {
					
					// Retain the original character at the current position 
					char originalChar = currentWordChar[j];
					
					// Replace the current character with every possible lowercase alphabet 
					for(char c = 'a'; c < 'z'; c++) {
						
						if(c == currentWordChar[j]) continue;
						
						currentWordChar[j] = c;
						String newWord = String.valueOf(currentWordChar);
						
						//Return the level + 1
						if(newWord.equals(target))
							return level+1;
						
						// Remove the word from the set if it is found in it 
						if(dictionary.contains(newWord)) {
							queue.add(newWord);
							dictionary.remove(newWord);
						}
					}
					// change it back to the old char
					currentWordChar[j] = originalChar;
					
				}
				
			}
			
			++level;
		}
		
		return -1;
	}

}
