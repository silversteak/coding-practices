package com.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class SegmentTreeSum {

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

		tree[index] = left+right;//Math.min(left, right);


	}


	static int query(int tree[],int index, int start, int end, int qs, int qe) {

		//Case 1 : No overlap in the query range
		if(qs > end || qe < start)
			return 0;

		//case 2 : Complete Overlap
		if(start >= qs && end <= qe)
			return tree[index];

		//Case 3 : Partial Overlap
		int mid = (end+start)/2;
		int leftAns = query(tree,2*index,start,mid,qs,qe);
		int rightAns = query(tree,2*index+1,mid+1,end,qs,qe);
		return leftAns+rightAns;//Math.min(leftAns, rightAns);
	}

	static void updateQuery(int tree[], int index, int start, int end, int i, int value) {
		//No overlap
		if(i < start || i > end)
			return;

		// Reached the leaf node
		if(start == end) {
			tree[index] += value;
			return;
		}

		int mid = (start+end)/2;
		updateQuery(tree,2*index,start,mid,i,value);
		updateQuery(tree,2*index+1,mid+1,end,i,value);
		tree[index] = tree[2*index]+tree[2*index+1];
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
		tree[index] = tree[2*index]+tree[2*index+1];
		return;
	}

	public static void main(String[] args) {

		/**/
		int arr[] = {1, 3, 5, 7, 9, 11};
		int n = arr.length;
		int tree[] = new int[4*n+1];
		Arrays.fill(tree, 0);
		int index = 1, s = 0, e = n-1;
		buildSegmentTree(tree,arr,index,s,e);
		//sc.ne
		System.out.println(Arrays.toString(tree));
		
		System.out.println(query(tree,1,s,e,2,4));
		
	//	System.out.println(Arrays.as);
		
		//updateQuery(tree,1,s,e,3,8);
		
		//
		
		updateQueryRange(tree,index,s,e,2,4,4);
		System.out.println(Arrays.toString(tree));
		System.out.println(query(tree,1,s,e,2,4));
		/*try {
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
		catch(Exception exp) {}*/

		// TODO Auto-generated method stub

	}

}
