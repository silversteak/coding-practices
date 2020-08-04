package com.amazon.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumber {

	private static Map<String, String> phone = new HashMap() {{
		put("2", "abc");
		put("3", "def");
		put("4", "ghi");
		put("5", "jkl");
		put("6", "mno");
		put("7", "pqrs");
		put("8", "tuv");
		put("9", "wxyz");
	}};

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return new ArrayList<>();
		}

		List<String> mnemonics = new ArrayList<>();
		listOfCombinations(0, new StringBuilder(), digits, mnemonics);
		return mnemonics;
	}

	public void listOfCombinations(int currentDigit, StringBuilder partialMnemonic, String digits, List<String> mnemonics){
		if(partialMnemonic.length() == digits.length()){
			// add to the mnemonics list
			mnemonics.add(String.valueOf(partialMnemonic));
			return;
		}

		// get the character of the digits like 2 3 - > 2 will be selected then 3
		char digitCharacter = digits.charAt(currentDigit);
		//ASCII to normal digits
		int digitAsInt = digitCharacter - '0';

		String letters = phone.get(String.valueOf(digitAsInt));

		for(char individualCharacter : letters.toCharArray()){
			// 1.Chose the character and append
			partialMnemonic.append(individualCharacter);
			// 2.Explore other possibilities
			listOfCombinations(currentDigit+1, partialMnemonic, digits, mnemonics);
			// 3.Reset the present Value of the partialMnemonic
			partialMnemonic.deleteCharAt(partialMnemonic.length()-1);
		}

	}

}
