package com.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermuteChar {
	
	private static boolean isOkay(int flag, int length) {
		if(flag > 1)
			return false;
		else if(flag == 1 && length%2==0)
			return true;
		else if(flag == 0 && length%2==1)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		try {
			int t;
			BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
			t = Integer.parseInt(inp.readLine());
				while(t>0) {
					String input = inp.readLine();
					int count[] = new int[26];
					int oddCount = 0; 
					char ch = 0;
					Arrays.fill(count, 0);
					//ArrayList<Integer> list = new ArrayList<Integer>();
					Map<Character, ArrayList<Integer>>mymap = new HashMap<Character, ArrayList<Integer>>();
					for(int i = 0; i < input.length(); i++) {
						if(!mymap.containsKey(input.charAt(i))) {
							ArrayList<Integer> myList = new ArrayList<Integer>();
							myList.add(i);
							mymap.put(input.charAt(i), myList);
						}else {
							mymap.get(input.charAt(i)).add(i);
						}
					}
				
					for(Map.Entry<Character,ArrayList<Integer>> key : mymap.entrySet()) {
						if(key.getValue().size()%2!=0) {
							oddCount++;
							ch = key.getKey();
						}
					}
					
					if(!isOkay(oddCount, input.length())) {
						System.out.print("-1");
					}else {
						int ans[] = new int[input.length()];
						Arrays.fill(ans, 0);
						if(oddCount == 1) {
							ans[input.length()/2]=mymap.get(ch).get(mymap.get(ch).size()-1);
							mymap.get(ch).remove(mymap.get(ch).size()-1);
							/*ans[input.length()/2]=mymap.get(input.charAt(index)).get(mymap.get(input.charAt(index)).size()-1);
							mymap.get(input.charAt(index)).remove(mymap.get(input.charAt(index)).size()-1);*/
						}
						//ArrayList<Integer> list = new ArrayList<Integer>();
						int left = 0, right = input.length();
						for(Map.Entry<Character,ArrayList<Integer>> entry : mymap.entrySet()) {
							for(int i = 0; i < entry.getValue().size();i++) {
								if(i%2==0)
									ans[left++]=entry.getValue().get(i);
								else
									ans[right-left]=entry.getValue().get(i);
							}
						
						}
						
						//System.out.println(ans.toString());
						for(int i = 0 ; i < ans.length;i++)
							System.out.print((ans[i]+1)+ " ");
					}
					System.out.println();
					
					
					t--;
				}
			// TODO Auto-generated method stub
			}
			catch(Exception e) {}
		// TODO Auto-generated method stub

	}

	

}
