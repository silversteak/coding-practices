package com.hackerEarth;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;
/**
 * @author TAUSEEF RAHAMAN
 */
public class Solution{
	
	public static void main(String[] args) {
		new Thread(null, new Runnable() {
			public void run() {
				new Solution().solve();
			}
		}, "1", 1 << 26).start();
	}
	
	void solve() {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		ScanReader in = new ScanReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		DIGIT_SUB solver = new DIGIT_SUB();
		solver.solve(1, in, out);
		out.close();
	}
	
	static class DIGIT_SUB {
		
		public void solve(int testNumber, ScanReader in, PrintWriter out) {
			int n = in.scanInt();
			int[] ans = new int[10];
			for (int i = 0; i < n; i++) {
				long temp = in.scanLong();
				boolean[] digits = new boolean[10];
				while (temp > 0) {
					digits[(int) (temp % 10)] = true;
					temp /= 10;
				}
				int max = 0;
				for (int j = 0; j < 10; j++) 
					if (digits[j]) 
						max = Math.max(ans[j], max);
				for (int j = 0; j < 10; j++) 
					if (digits[j]) 
						ans[j] = max + 1;
			}
			int answer = 0;
			for (int i = 0; i < 10; i++) 
				answer = Math.max(answer, ans[i]);
			out.println(answer);
		}
	}
	
	
	static class ScanReader {
		private byte[] buf = new byte[4 * 1024];
		private int index;
		private BufferedInputStream in;
		private int total;
		public ScanReader(InputStream inputStream) {
			in = new BufferedInputStream(inputStream);
		}
		
		private int scan() {
			if (index >= total) {
				index = 0;
				try {
					total = in.read(buf);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (total <= 0) return -1;
			}
			return buf[index++];
		}
		public int scanInt() {
			int integer = 0;
			int n = scan();
			while (isWhiteSpace(n)) n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				}
			}
			return neg * integer;
		}
		private boolean isWhiteSpace(int n) {
			if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
			else return false;
		}
		public long scanLong() {
			long integer = 0;
			int n = scan();
			while (isWhiteSpace(n)) n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				}
			}
			return neg * integer;
		}
	}
}