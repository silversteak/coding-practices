package com.codechef;

import java.util.Scanner;

public class HappyChef {

	public static long gcd(long a, long b) {
		if(b==0)
			return a;
		return gcd(b,a%b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		try {
			Scanner sc  = new Scanner(System.in);
			t = sc.nextInt();
			while(t > 0){
				long n, a, b, k, count = 0;
				n = sc.nextLong();
				a = sc.nextLong();
				b = sc.nextLong();
				k = sc.nextLong();

				count = (long) (n/a + n/b - 2*Math.floor(n/(a*b)));//2 *(a*b)/gcd(a,b);

				if(count >= k)
					System.out.println("Win");
				else
					System.out.println("Lose");
			}

			t--;
	}
	catch(Exception e) {

	}

}

}
