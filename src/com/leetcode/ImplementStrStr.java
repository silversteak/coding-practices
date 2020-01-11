package com.leetcode;

public class ImplementStrStr {
	
	public final static long prime = 23;

	public final static int INF = Integer.MAX_VALUE;
	
	public int strStr(String haystack, String needle) {

		//haystack.contains(s)

		if(haystack ==  null || needle.length() > haystack.length())
			return -1;

		if(needle == null || needle.length() == 0)
			return 0;
		/*
        boolean flag = true;

        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            int j;
            flag = true;
            for(j = 0; j < needle.length(); j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    flag = false;
                    break;
                }
            }

            if(flag == true)
                return i;
        }
		 */

		int countNeedle[] = new int[256];

		int countHaystack[] = new int[256];

		for(int i = 0; i < needle.length(); i++) {
			countNeedle[needle.charAt(i)]++;
			countHaystack[haystack.charAt(i)]++;
		}

		for(int i = countNeedle.length; i < haystack.length();i++) {
			if(areSame(countNeedle, countHaystack))
				return i;

			countHaystack[haystack.charAt(i)]++;

			countHaystack[haystack.charAt(i-needle.length())]--;	
		}

		return -1;




	}

	public boolean areSame(int[] countNeedle, int[] countHaystack) {

		for(int i = 0; i < countNeedle.length; i++) {
			if(countNeedle[i] != countHaystack[i])
				return false;
		}

		return true;
	}
	
	public static long createHashValue(String str, int n) {
		long value = 0;
		for(int i = 0; i < n; i++) {
			value += ((str.charAt(i) * Math.pow(prime, i))%INF);
		}
		return value;
	}
	
	public static long reCalculateHash(String str, int oldIndex, int newIndex, long oldHash, int patLength) {
		long newHash = oldHash - str.charAt(oldIndex);
		newHash = newHash/prime;
		newHash += ((str.charAt(newIndex) * Math.pow(prime, patLength-1))%INF);
		return newHash;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String needle = "ab";
		String haystack = "bbbaaaababa";
		
		//ab
		//acavdbab
		
		//"ababcaababcaabc"
		//"ababcaabc"
		
		//"baabbaaaaaaabbaaaaabbabbababaabbabbbbbabbabbbbbbabababaabbbbbaaabbbbabaababababbbaabbbbaaabbaababbbaabaabbabbaaaabababaaabbabbababbabbaaabbbbabbbbabbabbaabbbaa"
		//"bbaaaababa"
		
		long patternHashValue = createHashValue(needle, needle.length());
		long stringHashValue = createHashValue(haystack, needle.length());
		int index = 0;
		for(int i = 0; i <= haystack.length() - needle.length(); i++) {
			//if(i == 6)
				System.out.println(patternHashValue + "  " + stringHashValue);
			if(patternHashValue == stringHashValue) {
				index = i;
				break;
			}
			if(i < haystack.length()- needle.length())
				stringHashValue = reCalculateHash(haystack,i,i+needle.length(),stringHashValue,needle.length());
		}
		
		System.out.println(index);
		
		
		
	}

}
