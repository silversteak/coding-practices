package com.geeksforgeeks.dataStructure;

import java.util.Arrays;

public class NStacks {
	
	int topOfStack[];
	int stackData[];
	int nextIndex[];
	
	int nextAvailabe = 0;
	
	public NStacks(int numStack, int capacity) {
		topOfStack = new int[numStack];
		stackData = new int[capacity];
		nextIndex = new int[capacity];
		Arrays.fill(topOfStack, -1);
		for(int i = 0; i < capacity-1; i++) {
			nextIndex[i] = i+1;
		}
		nextIndex[capacity-1] = -1;
	}
	
	public void push(int stack, int value) throws Exception {
		
		if(stack < 0 || stack > topOfStack.length)
			throw new IndexOutOfBoundsException();
		
		if(nextAvailabe < 0) {
			throw new Exception("Overflow");
		}
			
		
		int currIndex = nextAvailabe;
		nextAvailabe = nextIndex[currIndex];
		
		stackData[currIndex] = value;
		nextIndex[currIndex] = topOfStack[stack];
		topOfStack[stack] = currIndex; 
		
	}
	
	public int pop(int stack) {
		
		if(stack < 0 || stack > topOfStack.length)
			throw new IndexOutOfBoundsException();
		
		int currIndex = topOfStack[stack];
		int value = stackData[currIndex];
		topOfStack[stack]  = nextIndex[currIndex];
		nextIndex[currIndex] = nextAvailabe;
		nextAvailabe = currIndex;
		return value;

	}

	public static void main(String[] args){
		NStacks stk = new NStacks(3, 5);
		try {
			stk.push(1, 91);
			stk.push(1, 92);
			stk.push(1, 93);
			stk.push(1, 94);
			stk.push(1, 95);
			stk.push(1, 96);			
		}catch(Exception e) {
			
		}
	}

}
