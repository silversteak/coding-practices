package com.geeksforgeeks.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MavenTopoLogicalSort {

	static class Graph{
		int v;
		ArrayList<ArrayList<Integer>> adjList;
	
		Graph(int v){
			this.v = v;
			adjList = new ArrayList<ArrayList<Integer>>(v);
			for(int i = 0; i < v; i++)
				adjList.add(new ArrayList<Integer>());
		}
		
	    void addEdge(int v,int w) { adjList.get(v).add(w); }
	    
	    void topologicalSort() {
	    	
	    	Stack<Integer> stk = new Stack<Integer>();
	    	
	    	boolean visited[] = new boolean[this.v];
	    	
	    	for(int i = 0; i < this.v; i++) {
	    		if(visited[i] == false)
	    			topologicalSortUtil(i, visited, stk);
	    	}
	    	
	    	while(!stk.isEmpty()) {
	    		System.out.print(stk.pop() + " ");
	    	}
	    	
	    }

		private void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> stk) {
			
			visited[i] = true;
			
			ArrayList<Integer> adj = adjList.get(i);
			
			for(Integer v : adj) {
				if(!visited[i]) {
					topologicalSortUtil(v, visited, stk);
				}
			}	
			
			stk.add(i);
			
		}

	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(6);  
        g.addEdge(5, 2);  
        g.addEdge(5, 0);  
        g.addEdge(4, 0);  
        g.addEdge(4, 1);  
        g.addEdge(2, 3);  
        g.addEdge(3, 1);  
    
        System.out.println("Following is a Topological " +  
                           "sort of the given graph");  
        g.topologicalSort(); 
	}

}
