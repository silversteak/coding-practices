package com.amazon.searching;

public class MajorityElement {

	static int majorityElement(int nums[], int size)
	{
		int el = nums[0];
		int count = 1;
		for(int i = 1; i < nums.length; i++){
			if(el == nums[i]){
				count++;
			}else{
				count--;
				if(count == 0){
					el = nums[i];
					count++;
				}

			}
		}


		count = 0;
		for(int i = 0; i < size; i++){
			if(el == nums[i])
				count++;
		}

		return count > size / 2 ? el : -1;

	}

}
