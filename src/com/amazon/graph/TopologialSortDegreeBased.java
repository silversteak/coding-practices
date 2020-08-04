package com.amazon.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologialSortDegreeBased {
	
	static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int n) {
	
		int ans[]=new int[n];
		
		Queue<Integer> q=new LinkedList<>();
		
		int indegree[]=new int[n];
		
		for(int i=0;i<n;i++)
			for(int u:adj.get(i))
				indegree[u]++;
		
		for(int i=0;i<n;i++)
			if(indegree[i]==0)
				q.add(i);

		
		int c=0;
		
		while(!q.isEmpty()){
			int v=q.poll();
			ans[c++]=v;
			for(int u:adj.get(v)){
				indegree[u]--;
				if(indegree[u]==0)
					q.add(u);
			}
		}
		return ans;

    }
			
}
