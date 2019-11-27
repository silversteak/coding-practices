package com.codechef;

import java.util.Arrays;

public class XORSegmentTree {

	private static void updateQueryRange(int[] tree, int index, int start, int end, int qs, int qe, int value) {
		//1. No overlap
			if(qs > end || qe < start)
				return;
		//2. Reached the last node
			if(start == end) {
				tree[index] += value;
				return;
			}
		//3. Partial Overlap
			int mid = (start+end)/2;
			updateQueryRange(tree,2*index,start,mid,qs,qe,value);
			updateQueryRange(tree,2*index+1,mid+1,end,qs,qe,value);
			tree[index] = tree[2*index] ^ tree[2*index+1];
			return;
	}	

	private static void updateSegmentTree(int[] tree, int[] arr, int index, int start, int end, int i, int value) {
		//1.No Overlap
		if(i > end || i < start)
			return ;
		//2.complete Overlap
		if(start == end) {
			tree[index] += value;
			return;
		}
		//3.Partial Overlap
		int mid = (start+end)/2;
		updateSegmentTree(tree, arr,2*index, start, mid,i,value);
		updateSegmentTree(tree, arr,2*index+1,mid+1,end,i,value);
		tree[index] = tree[2*index]^tree[2*index+1];
		return;
	}

	private static int query(int[] tree, int index, int start, int end, int qs, int qe) {

		//1.No Overlap
		if(qs > end || qe < start)
			return 0;

		//2.Complete Overlap
		if(start >= qs && end <= qe)
			return tree[index];

		//3. Partial Overlap
		int mid = (start+end)/2;
		int leftAns = query(tree,2*index,start,mid,qs,qe);
		int rightAns = query(tree,2*index+1,mid+1,end,qs,qe);
		return leftAns ^ rightAns;
	}

	private static void buildSegmentTree(int[] tree, int[] arr, int index, int start, int end) {

		//1. Termination Case
		if(start > end)
			return;

		//2. If it is the last leaf
		if(start == end) {
			tree[index] = arr[start];
			return;
		}

		//3. Recursive case
		int mid = (start+end)/2;
		buildSegmentTree(tree,arr,2*index,start,mid);
		buildSegmentTree(tree,arr,2*index+1,mid+1,end);
		int left = tree[2*index];
		int right = tree[2*index+1];
		tree[index] = left ^ right;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {1, 3, 5, 7, 9, 11};
		int n = arr.length;
		int tree[] = new int[4*n+1];
		Arrays.fill(tree, 0);
		int index = 1, s = 0, e = n-1;
		buildSegmentTree(tree,arr,index,s,e);
		//sc.ne
		System.out.println(Arrays.toString(tree));

		System.out.println(query(tree,1,s,e,2,4));
		updateSegmentTree(tree,arr,index,s,e, 4, 10);
		System.out.println(Arrays.toString(tree));

		//	System.out.println(Arrays.as);

		//updateQuery(tree,1,s,e,3,8);

		//

		updateQueryRange(tree,index,s,e,2,4,4);
		System.out.println(Arrays.toString(tree));
		System.out.println(query(tree,1,s,e,2,4));

	}



}
