package com.gfg.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StackIMPL {

	public static void stockSpan(int arr[], int n) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		stack.add(0);
		list.add(-1);
		for(int i = 1; i < n; i++) {
			
			while(!stack.isEmpty() && arr[i] >  arr[stack.peek()])
				stack.pop();
			list.add(stack.isEmpty() ? i+1 : i - stack.peek());
			stack.add(i);
		}
		
		System.out.println(list);
		

	}
	
	public static void previousGreaterElement(int arr[], int n) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		stack.add(arr[0]);
		list.add(-1);
		for(int i = 1; i < n; i++) {
			
			while(!stack.isEmpty() && arr[i] >= stack.peek())
				stack.pop();
			list.add(stack.isEmpty() ? -1 : stack.peek());
			stack.add(arr[i]);
		}
		
		System.out.println(list);
		
	}
	
	public static void nextGreaterElemet(int arr[],int n) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		stack.add(arr[n-1]);
		list.add(-1);
		for(int i = n - 2; i >=0; i--) {
			
			while(!stack.isEmpty() && arr[i] > stack.peek())
				stack.pop();
			list.add(stack.isEmpty() ? -1 : stack.peek());
			stack.add(arr[i]);
			
		}
		
		Collections.reverse(list);
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		
		int arr[] = {5,15,10,8,6,12,9,18};
		nextGreaterElemet(arr, arr.length);
		previousGreaterElement(arr, arr.length);
		stockSpan(arr, arr.length);
	}

	
}
