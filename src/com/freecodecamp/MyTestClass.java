package com.freecodecamp;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class MyTestClass {

	public static void main(String[] args) {
	/*	DynamicArray<Integer> ob = new DynamicArray<>();
		System.out.println(ob.toString());
		ob.add(1);
		ob.add(4);
		System.out.println(ob.toString());
		ob.add(7);
		System.out.println(ob.size());
		System.out.println(ob.toString());
		ob.add(10);
		ob.contains(7);
		ob.removeAt(2);
		ob.add(11);
		System.out.println(ob.toString());
		System.out.println(ob.size());
		
		Iterator it = ob.iterator();
		
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}*/
		
		Stack<String> stk = new Stack<>();
				
		stk.push("A");
		stk.push("B");
		stk.push("C");
		stk.push("D");
		System.out.println(stk.pop());
		stk.push("Z");
		System.out.println(stk.top());
		stk.push("X");
		
		System.out.println(stk.toString());
		
	}

}
