package com.amazon.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class GraphTraversing {
	
	public static class Node{
		int vertices;
		LinkedList<Node> adjList;

		Node(int vertices){
			this.vertices = vertices;
			this.adjList = new LinkedList<>();
		}

		/*void addEdge(int v, int e) {
			adjList.get(v).add(e);
		}*/
	}
	
	public static void dfsPrint(Node node) {
		
		Stack<Node> stack = new Stack<>();
		Set<Node> seen = new HashSet<>();
		
		stack.add(node);
		
		while(!stack.isEmpty()) {
			Node curr = stack.pop();
			
			if(!seen.contains(curr)) {
				seen.add(curr);
				System.out.println(curr.vertices);
			}
			
			for(Node adjNode : node.adjList) {
				if(!seen.contains(adjNode)) {
					stack.push(adjNode);
				}
			}
			
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
