package com.codechef;

import java.math.BigInteger;

public class BigIntegerOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			BigInteger br = new BigInteger("876567890876545678909876543");
			BigInteger test = BigInteger.valueOf(111); 
			test = test.multiply(new BigInteger("11")).divide(BigInteger.valueOf(111));
			System.out.println(test);
	}

}
