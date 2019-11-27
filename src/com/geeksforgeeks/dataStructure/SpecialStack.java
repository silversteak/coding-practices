package com.geeksforgeeks.dataStructure;

import java.util.Stack;

public class SpecialStack extends Stack<Integer> {
	
	Stack<Integer> dummy = new Stack<>();
	
	void push(int x) {
		//super.push(x);
		if(super.isEmpty()) {
			super.push(x);
			dummy.push(x);
		}else {
			super.push(x);
			int y = dummy.peek();
			if(x < y) {
				dummy.push(x);
			}else {
				dummy.push(y);
			}
		}
	}
	
	public Integer pop() {
		if(!isEmpty()) {
			int temp = super.pop();
			dummy.pop();
			return temp;
		}
		return -1;
	}
	
	public Integer getMin() {
		if(!isEmpty()) {
			super.pop();
			int temp = dummy.pop();
			return temp;
		}
		return -1;
	} 
	

	public static void main(String[] args) {
		SpecialStack stk = new SpecialStack();
		stk.push(15);
		stk.push(5);
		stk.push(65);
		stk.push(1);
		stk.push(43);
		
		System.out.println(stk.getMin());
		
		System.out.println(stk.getMin());
		
		System.out.println(stk.pop());
		
		System.out.println(stk.getMin());
	}

}
