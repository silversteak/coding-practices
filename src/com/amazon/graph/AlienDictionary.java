package com.amazon.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Direct implementation of topological sorting

public class AlienDictionary {

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
	}

	public static String findOrder(String [] dict, int N, int K){

		Graph graph = new Graph(K);

		for(int i = 0; i < dict.length - 1; i++) {
			String word1 = dict[i];
			String word2 = dict[i+1];

			for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if(word1.charAt(j) != word2.charAt(j)) {
					graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
					break;
				}
			}
		}

		return topologicalSort(K, graph);

	}

	private static String topologicalSort(int K, Graph graph) {
		ArrayList<ArrayList<Integer>> adj = graph.adjList;
		
		Queue<Integer> q=new LinkedList<>();

		int indegree[]=new int[K];
		char ans[] = new char[K];
		
		for(int i=0;i<K;i++)
			for(int u:adj.get(i))
				indegree[u]++;

		for(int i=0;i<K;i++)
			if(indegree[i]==0)
				q.add(i);


		int c=0;

		while(!q.isEmpty()){
			int v=q.poll();
			ans[c++]=(char) v;
			for(int u:adj.get(v)){
				indegree[u]--;
				if(indegree[u]==0)
					q.add(u);
			}
		}
		return String.copyValueOf(ans);
	}

}
