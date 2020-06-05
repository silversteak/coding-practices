package com.leetcode;

import java.util.Stack;

public class BackspacesString {

	public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stkA = new Stack<>();
        Stack<Character> stkB = new Stack<>();
        
        for(char ch : S.toCharArray()){
            if(!stkA.isEmpty()){
                if(ch == '#')
                    stkA.pop();
                else
                	stkA.push(ch);
            }else{
                if(ch != '#')
                   stkA.push(ch);
            }
        }
        
        for(char ch : T.toCharArray()){
            if(!stkB.isEmpty()){
                if(ch == '#')
                    stkB.pop();
            }else{
                if(ch != '#')
                  stkB.push(ch);
            }
        }
        
        while(!stkA.isEmpty() && !stkB.isEmpty()){
            if(stkA.pop() != stkB.pop())
                return false;
        }
        
        System.out.println(stkA.size() + "    "+stkB.size());
        
        return stkA.isEmpty() == stkB.isEmpty() ? true: false; 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//"xywrrmp"
		//"xywrrmu#p"
		backspaceCompare("xywrrmp", "xywrrmu#p");
		
	}

}
