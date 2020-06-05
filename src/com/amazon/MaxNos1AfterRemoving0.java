package com.amazon;

public class MaxNos1AfterRemoving0 {
	
	public static int max(int arr[]) {
		
		int pz = -1, ppz = -1, index = -1, max = -1;
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			if(arr[i] == 0) {
				if(ppz != -1) {		
					if(i - ppz > max) {
						max = i - ppz;
						index = pz;
					}
				}
				ppz = pz;
				pz = i;
			}
		}
		
		if(max == -1) {
			// there is only two zeros
			if(ppz != -1) {
				if(pz > (n - ppz - 1))
					index = pz;
				else
					index = ppz;
			}else {
				// only  one zero
				index = pz;
			}
			
		}else {
			// check for the last index 
			if(n - ppz > max)
				index = pz;
		}
		
		return index;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
