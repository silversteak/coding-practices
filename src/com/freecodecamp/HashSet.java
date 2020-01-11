package com.freecodecamp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSet {
	
	private HashMap<Integer, Integer> mymap;
	
	private final Integer COUNT = 1;
	
	public HashSet() {
		super();
		mymap = new HashMap<>();
	}

	public int size() {
		return mymap.size();
	}

	public boolean isEmpty() {
		return mymap.isEmpty();
	}

	public boolean contains(Integer o) {
		return mymap.containsKey(o);
	}

	public Iterator<Integer> iterator() {
		return mymap.keySet().iterator();
	}


	public boolean add(Integer e) {
		return mymap.put(e, COUNT) == null;
	}

	public boolean remove(Integer key) {
		return mymap.remove(key) == COUNT;
	}

	public void clear() {
		mymap.clear();
	}
	
	public Set<Integer> union(List<Integer> A, List<Integer> B){
		mymap = new HashMap<>();
		for(int i = 0; i < A.size(); i++) {
			if(!mymap.containsKey(A.get(i)))
				mymap.put(A.get(i), COUNT);			
		}
		for(int i = 0; i < B.size(); i++) {
			if(!mymap.containsKey(B.get(i)))
				mymap.put(B.get(i), COUNT);	
		}
		return mymap.keySet();
		
	}

	public static void main(String args[]) {
		HashSet myset = new HashSet();
		for(int i = 0; i < 10; i++)
			myset.add(i*10);
		
		myset.add(10);
		
		Iterator<Integer> itr = myset.iterator();

		System.out.println("Traversing over Set using Iterator");
		while(itr.hasNext()){
		  System.out.print(itr.next() + " ");
		}
		
		myset.remove(40);
		
		itr = myset.iterator();
		
		System.out.println("Traversing over Set using Iterator");
		while(itr.hasNext()){
		  System.out.print(itr.next() + " ");
		}
		
		System.out.println(myset.union(Arrays.asList(7,5,2,3), Arrays.asList(91,5,7,3)));
	}
	

}
