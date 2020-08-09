package com.amazon.arrays;

public class ConvertFive {
	int helper(int num){
		if(num == 0)
			return 5;

		int place = 1, result = 0;    
		while(num > 0){
			if(num%10 == 0)
				result += (5*place);

			num /= 10;
			place *= 10;
		}
		return result;
	}

	int convertfive(int num) {
		return num + helper(num);            
	}

}
