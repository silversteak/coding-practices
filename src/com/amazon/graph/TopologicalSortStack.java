package com.amazon.graph;

import java.util.ArrayList;
import java.util.Stack;


public class TopologicalSortStack {

	static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
		boolean visited[] = new boolean[10001];
		Stack<Integer> stack = new Stack<>();
		//ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			if(!visited[i])
				dfsUtil(i,adj, visited, stack);
        }
		int index = 0;
        int ans[] = new int[stack.size()];
		while(!stack.isEmpty()) {
        	ans[index] = stack.peek();
        	stack.pop();
        	++index;
        }      
		return ans;
	}

	private static void dfsUtil(int startVertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {		
		visited[startVertex] = true;
		for(int vertex : adj.get(startVertex)) {
			if(!visited[vertex]) {
				dfsUtil(vertex, adj, visited, stack);
			}
		}
		stack.push(startVertex);
	}
}
