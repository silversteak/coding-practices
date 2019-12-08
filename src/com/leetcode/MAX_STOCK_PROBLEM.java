package com.leetcode;

public class MAX_STOCK_PROBLEM {

	// Use 
	public int maxProfit(int[] prices) {
		
		if(prices == null || prices.length == 0)
			return 0;
		
		int maxProfit =0 , buy = 0, sell = 0, len = prices.length;
		for(int i = 0; i < len-1; i++) {
			while( i < len - 1 &&  prices[i] < prices[i+1]) {
				buy = prices[i];
				System.out.println("Buy" + buy);
				i++;
			}	
			while(i < len - 1 && prices[i] > prices[i+1] && buy != 0) {
				sell = prices[i];
				System.out.println("sell" + sell);
				i++;
			}
			maxProfit +=(sell-buy);
			buy = 0; sell = 0;
		}
		return maxProfit;
	}



public static void main(String[] args) {
	// TODO Auto-generated method stub
	int arr[] = {7,1,5,3,6,4};
	

}

}
