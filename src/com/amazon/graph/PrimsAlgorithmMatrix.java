package com.amazon.graph;

import java.util.Arrays;

public class PrimsAlgorithmMatrix {
	
	public static void prims(int [][] graph, int V) {
		
		// key array to get the minimum key each time;
		int key[] = new int[V];
		Arrays.fill(key, Integer.MAX_VALUE);
		
		//boolean array to represent set of vertices not included in the mst
		boolean mstSet[] =new boolean[V];
		
		//Always inlcuded in the keyset
		key[0] = 0;
		
		//Res 
		int res = 0;
		
		//The MST will have V vertices
		for(int count = 0; count < V; count++) {
			
			//get the minimum key 
			int u = getMinKey(key, mstSet, V);
			
			//mark u as visted
			mstSet[u] = true;
			
			res = res + key[u];
			
			for (int v = 0; v < V; v++)

                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && !mstSet[v]  && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                }
			
		}
		
		System.out.println(res);
		
	}

	private static int getMinKey(int[] key, boolean[] mstSet, int V) {
		
		int min = Integer.MAX_VALUE, minIndex = -1;
		for(int v = 0; v < V; v++) {
			if(!mstSet[v] && key[v] < min) {
				min = key[v];
				minIndex = v;
			}
		}
		
		return minIndex;
	}
	
	public static void main(String args[]) {
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 } };
         
        prims(graph, 5);    
	}
	
}
