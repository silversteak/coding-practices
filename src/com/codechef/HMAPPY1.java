package com.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HMAPPY1 {

	static void buildSegmentTree(int tree[], int arr[],int index, int start, int end) {

		//Terminate Case

		//If it is the leaf node  

		// Recursive Case




	}


	static int query(int tree[],int index, int start, int end, int qs, int qe) {

		// No overlap in the query range

		//Complete Overlap


		//Partial Overlap
		
		return 0;
	}

	static void updateQuery(int tree[], int index, int start, int end, int i, int value) {
		//No overlap
		

				// Reached the leaf node

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
		// TODO Auto-generated method stub
		try {
			int t;
			BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
			t = Integer.parseInt(inp.readLine());
			while(t-->0) {
				String dummy,dummyArr[];
				int n, q, k, inputs[]= {};
				char queries[];
				dummy = inp.readLine();
				dummyArr = dummy.trim().split("\\s");
				n = Integer.valueOf(dummyArr[0]);
				q = Integer.valueOf(dummyArr[1]);
				k = Integer.valueOf(dummyArr[2]);
				dummy = inp.readLine();
				dummyArr = dummy.trim().split("\\s");
				for(int i = 0; i < dummyArr.length; i++)
					inputs[i] = Integer.parseInt(dummyArr[i]);
				dummy = inp.readLine();
				queries = dummy.trim().toCharArray();



			}
			// TODO Auto-generated method stub
		}
		catch(Exception e) {}
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

	}



}
