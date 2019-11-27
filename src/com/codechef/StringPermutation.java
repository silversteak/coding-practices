package com.codechef;

public class StringPermutation {

	public static void permute(String str1, int left, int right) {

		if(left == right)
			System.out.println(str1);
		else {
			for(int i = left; i <=right; i++) {
				str1 = swap(str1, left, i);
				permute(str1,left+1,right);
				str1 = swap(str1,left,i);
			}

		}

	}


	public static String swap(String a, int i, int j) {
		char temp;
		char [] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "ABC";
		int len = str.length();
		//permute(str,0,len-1);

		System.out.println(swap("ABCDF", 0, 4));
		
	}

}
