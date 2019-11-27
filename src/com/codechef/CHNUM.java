package com.codechef;

import java.util.Scanner;

public class CHNUM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		try {
			Scanner sc  = new Scanner(System.in);
			t = sc.nextInt();
			while(t > 0){
				long n, countNeg = 0, countPos = 0, num = 0;
				n = sc.nextLong();
				for(long i = 0; i < n; i++) {
					num = sc.nextLong();
					if(num > 0)
						countPos++;
					else
						countNeg++;
				}
				
				if(countNeg == 0)
					System.out.println(countPos + " " +countPos);
				else
					System.out.println(Math.max(countNeg,countPos) + " " +Math.min(countNeg,countPos));
				
			}

				

			t--;
	}
	catch(Exception e) {}
	}

}
