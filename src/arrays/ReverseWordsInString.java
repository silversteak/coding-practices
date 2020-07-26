package arrays;

public class ReverseWordsInString {

	public static String reverseWords(String s) {
		if (s == null) return null;

		char[] a = s.toCharArray();
		int n = a.length;
		// reverse the sentence
		reverse(a, 0, n-1);
		// reverse the each word
		reverseWords(a, 0, n-1);
		// remove the spaces

		return cleanSpaces(a, 0, n);
		//return String.valueOf(a);
	}

	private static String cleanSpaces(char[] a, int i, int n){
		int start = 0, end = 0;

		for( ; i < n; i++){
			while(end < n && a[end] == ' ') end++;
			
			if(end < n)
				a[start++] = a[end++];
			
			if(end < n && a[end] == ' ') {
				a[start++] = a[end++];
			}
			
			
		}
		return String.valueOf(a).substring(0, i);
	}

	private static void reverseWords(char[] a, int i, int n){
		// j = end; 
		int start = 0, end;
		for(end = 0; end < n; end++){
			while(start < n && a[start] == ' ') start++;

			if(a[end] == ' ' && end > start){
				reverse(a, start, end-1);
				start = end + 1;
			}
		}
		reverse(a, start, end);

	}

	private static void reverse(char[] a, int i, int j) {
		while (i < j) {
			char t = a[i];
			a[i++] = a[j];
			a[j--] = t;
		}
	}

	public static void main(String[] args) {

		reverseWords("the sky is                  blue");
		
	}

}
