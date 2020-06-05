package com.geeksforgeeks.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphColoring {

	static class Graph{
		int vertices;
		LinkedList<LinkedList<Integer>> adjList;

		Graph(int vertices){
			this.vertices = vertices;
			this.adjList = new LinkedList<LinkedList<Integer>>();
			for(int i = 0; i <= vertices; i++) {
				adjList.add(new LinkedList<Integer>());
			}
		}

		void addEdge(int v, int e) {
			adjList.get(v).add(e);
		}


	}

	private static boolean graphColoring(LinkedList<LinkedList<Integer>> adjList, int vertices) {
		
		int colour[] = new int[vertices];
		Arrays.fill(colour,-1);
		for(int i = 0; i < vertices; i++) {
			if(colour[i] == -1)
				if(!graphColoringUtil(adjList, i, colour, vertices))
					return false;
		}
		
		return true;
	}
	
	
	private static boolean graphColoringUtil(LinkedList<LinkedList<Integer>> adjList,int vertex, int[] colour, int vertices) {

		Queue<Integer> queue = new LinkedList<>(); 
		queue.add(vertex);
		colour[vertex] = 1;
		
		while(!queue.isEmpty()) {
			
			int curr = queue.poll();
			
			for(int node : adjList.get(curr)) {
				if(colour[node] == colour[curr])
					return false;
				
				if(colour[node] == -1) {
					colour[node] = 1 - colour[curr];
					queue.add(node);
				}
				
			}
			
		}
		
		return true;
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] input = {{1,2},{1,3},{1,4},{3,5},{7,8},{8,9}};
		Graph graph = new Graph(10);
		for(int i = 0; i < input.length; i++) {
			graph.addEdge(input[i][0], input[i][1]);
		}

		System.out.println(graphColoring(graph.adjList, graph.vertices));
		

	}

}
