package com.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAlgorithms {

	/**
	 * 
	 * @param startVertex - starting vertex for traversal
	 * @param g - the adjacency list fo the graph
	 * @param visited - boolean array to store the visited 
	 * @param ans - arraylist in dfs traversal
	 */
	
	static void dfsUtil(int startVertex, ArrayList<ArrayList<Integer>> g, boolean visited[], ArrayList<Integer> ans){
        // update the startVertex;
        visited[startVertex] = true;
        ans.add(startVertex);
        
        for(int i = 0; i < g.get(startVertex).size(); i++){
            int destination = g.get(startVertex).get(i);
            if(!visited[destination]){
                dfsUtil(destination, g, visited, ans);
            }
        }
        
    }
    
	/**
	 * 
	 * @param g
	 * @param N
	 * @return
	 */
	
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
        boolean visited[] = new boolean[N];
        ArrayList<Integer> ans = new ArrayList<>();
        dfsUtil(0,g, visited, ans);
        
        return ans;
    }
	
	
	/**
	 * BFS Traversal
	 * @param g adjacency List of the graph 
	 * @param N - total number of vertices
	 * @return
	 */
	
	static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        // use queue to store the vertices
        
        boolean visited[] = new boolean[N+1];
        int startVertex = 0;
          
        Queue<Integer> queue = new LinkedList<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        visited[startVertex] = true;
        queue.add(startVertex);
        
        while(!queue.isEmpty()){
            int u = queue.poll();
            ans.add(u);
            
            for(int v : g.get(u)){
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        
        return ans;
    }
	
	
	/**
	 * This is the helper function for the isCyclic graph method
	 * @param visited
	 * @param recursion
	 * @param adj
	 * @param startIndex
	 * @return
	 */
	
	static boolean isCyclicDFS(boolean visited[], boolean recursion[], ArrayList<ArrayList<Integer>> adj, int startIndex){
        //Mark as true
		visited[startIndex] = true;
        // Mark as true
		recursion[startIndex] = true;
        
        for(int index : adj.get(startIndex)){
            if(!visited[index] && isCyclicDFS(visited, recursion, adj, index))
                return true;
            
            else if(recursion[index])
                return true;
        }
        
        recursion[startIndex] = false;
        return false;
        
    }
    
	/**
	 * 
	 * @param adj
	 * @param V
	 * @return
	 */
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
    	//Visted array to check for each node
        boolean visited[] = new boolean[V+1];
        
        //Array used to track the recursion of the particular cycle
        boolean recursion[] = new boolean[V+1];
        
        //int startIndex = 0;
        for(int index = 0; index < V; index++){
            if(!visited[index]){
                 if(isCyclicDFS(visited, recursion, adj, index))
                    return true;
            }
        }
        return false;
    }
	
    static boolean isCyclicUndirectedDFS(boolean visited[], int parent, ArrayList<ArrayList<Integer>> adj, int startIndex){
        visited[startIndex] = true;
        //recursion[startIndex] = true;
        
        for(int u : adj.get(startIndex)){
            
        	//Check the adjacent not equal to the parent
            if(u != parent){
            	//
                if(visited[u])
                    return true;
                else{
                    if(isCyclicUndirectedDFS(visited, startIndex, adj, u)){
                        return true;
                    }
                }    
            }
            
            /*if(!visited[u] && isCyclicDFS(visited, startIndex, adj, u))
                return true;
            
            else if(u != parent)
                return true;
                */
        }
        
        return false;
        
    }
    
    static boolean isCyclicUndirected(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean visited[] = new boolean[V];
        //boolean recursion[] = new boolean[V+1];
        
        //int startIndex = 0;
        
        for(int index = 0; index < V; index++){
            if(!visited[index]){
                 if(isCyclicUndirectedDFS(visited, -1, adj, index))
                    return true;
            }
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		

	}

}
