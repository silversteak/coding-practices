package com.amazon.arrays;

public class TrappingRainWater {
	
	static int trappingWater(int height[], int n) { 
	       if(height == null)
				return 0;
			
			int maxSeenSoFar = 0;
			int rightMaxSeen[] = new int[height.length];
			int leftMaxSeen = 0;
			int rainwater = 0;
			
			for(int i = height.length-1; i >= 0; i--) {
				if(height[i] > maxSeenSoFar) {
					maxSeenSoFar = height[i];
					rightMaxSeen[i] = maxSeenSoFar;
				}else {
					rightMaxSeen[i] = maxSeenSoFar;
				}
			}
			
			for(int i = 0; i < height.length; i++) {
				rainwater = rainwater + Integer.max(Integer.min(leftMaxSeen, rightMaxSeen[i])-height[i],0); 
				
				if(height[i] > leftMaxSeen)
					leftMaxSeen = height[i];
				
			}
			
			return rainwater;
	        
	    } 

}
