package com.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class SegmentTree {

	private static Scanner sc;

	static void buildSegmentTree(int tree[], int arr[],int index, int start, int end) {

		//Terminate Case
		if(start > end)
			return;

		//If it is the leaf node  
		if(start == end) {
			tree[index] = arr[start];
			return;
		}

		// Recursive Case
		int mid = (start+end)/2;

		buildSegmentTree(tree,arr,2*index,start,mid);
		buildSegmentTree(tree,arr,2*index+1,mid+1,end);

		int left = tree[2*index];
		int right = tree[2*index+1];

		tree[index] = Math.min(left, right);


	}


	static int query(int tree[],int index, int start, int end, int qs, int qe) {

		// No overlap in the query range
		if(qs > end || qe < start)
			return Integer.MAX_VALUE;

		//Complete Overlap
		if(start >= qs && end <= qe)
			return tree[index];

		//Partial Overlap
		int mid = (end+start)/2;
		int leftAns = query(tree,2*index,start,mid,qs,qe);
		int rightAns = query(tree,2*index+1,mid+1,end,qs,qe);
		return Math.min(leftAns, rightAns);
	}
	
	static void updateQuery(int tree[], int index, int start, int end, int i, int value) {
		//No overlap
		if(i < start || i > end)
			return;
		
		// Reached the leaf node
		if(start == end) {
			tree[index] = value;
			return;
		}
		
		int mid = (start+end)/2;
		updateQuery(tree,2*index,start,mid,i,value);
		updateQuery(tree,2*index+1,mid+1,start,i,value);
		tree[index] = Math.min(tree[2*index], tree[2*index+1]);
		return;
	}
	
	static void updateQueryRange(int tree[], int index, int start, int end, int rs, int re, int value) {
		//No overlap
		if(re < start || rs > end)
			return;
		
		// Reached the leaf node
		if(start == end) {
			tree[index] += value;
			return;
		}
		
		int mid = (start+end)/2;
		updateQueryRange(tree,2*index,start,mid,rs,re,value);
		updateQueryRange(tree,2*index+1,mid+1,end,rs,re,value);
		tree[index] = Math.min(tree[2*index], tree[2*index+1]);
		return;
	}
	

	public static void main(String[] args) {
		/**/
		int arr[] = {1,3,2,-2,4,5};
		int n = arr.length;
		int tree[] = new int[4*n+1];
		Arrays.fill(tree, Integer.MAX_VALUE);
		int index = 1, s = 0, e = n-1;
		buildSegmentTree(tree,arr,index,s,e);
		//sc.ne
		// System.out.println(tree);

		try {
			sc = new Scanner(System.in);
			int t = sc.nextInt();
			while(t-- > 0) {
				int qs, qe;
				qs = sc.nextInt();
				qe = sc.nextInt();
				System.out.println("Min value between range is");
				System.out.println(query(tree,1,s,e,qs,qe));
			}
		}
		catch(Exception exp) {}

	}

}
