package com.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class TopView {

	static Map<Integer, Node> hash = new HashMap<>();
	
	static class Node{ 
		int data;
		Node left;
		Node right;
	}

	static class Pair{
		int height;
		Node node;
		Pair(int height, Node node){
			this.height = height;
			this.node = node;
		}
	}

	public static void topView(Node root) {

		Queue<Pair> queue = new LinkedList<>();

		if(root != null)
			queue.add(new Pair(0, root));

		while(!queue.isEmpty()){
			Pair temp = queue.poll();

			if(!hash.containsKey(temp.height)){
				hash.put(temp.height, temp.node);
			}

			if(temp.node.left != null){
				queue.add(new Pair(temp.height - 1, temp.node.left));
			}    

			if(temp.node.right != null){
				queue.add(new Pair(temp.height + 1, temp.node.right));
			}

		}

		for(Map.Entry<Integer, Node> entry : hash.entrySet()){
			System.out.print(entry.getValue().data + " ");
		}


	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
