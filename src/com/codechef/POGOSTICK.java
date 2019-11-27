package com.codechef;

import java.util.*;
import java.io.*;
import java.text.*;
//Solution Credits: silversteak
public class POGOSTICK{
	//SOLUTION BEGIN
	void pre() throws Exception{}
	void solve(int TC) throws Exception{
		int n, k, max = -1<<30;
		n = ni(); 
		k = ni();
		int arr[] = new int[n];
		int dp[] = new int[n];
		Arrays.fill(dp, 0);
		for(int i = 0; i < n; i++)
			arr[i] = ni();
		/*dp[0] = arr[0];
		max = arr[0];
		for(int i = 1; i < k; i++) {
			dp[i] = arr[i];
			max = Math.max(dp[i], max);
		}
		for(int i = k; i < n; i++) {
			int temp = Math.max(dp[i-k] + arr[i], arr[i]);
			dp[i] = temp;
			max = Math.max(dp[i], max);
		}*/
		
		for(int i = n-1; i>=0; i--) {
			dp[i] = arr[i];
			if(i+k < n)
				dp[i] += arr[i+k];
			max = Math.max(dp[i], max);
		}
		
		pn(max);
	}
	//SOLUTION END
	void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
	long mod = (long)1e9+7, IINF = (long)1e10;
	final int INF = (int)1e9, MX = (int)1e4+1;
	DecimalFormat df = new DecimalFormat("0.000000000000000");
	double PI = 3.1415926535897932384626433832792884197169399375105820974944, eps = 1e-8;
	static boolean multipleTC = true, memory = false;
	FastReader in;PrintWriter out;
	void run() throws Exception{
		in = new FastReader();
		out = new PrintWriter(System.out);
		int T = (multipleTC)?ni():1;
		//Solution Credits: Taranpreet Singh
		pre();
		for(int t = 1; t<= T; t++)
			solve(t);
		out.flush();
		out.close();
	}
	public static void main(String[] args) throws Exception{
		if(memory)new Thread(null, new Runnable() {public void run(){try{new POGOSTICK().run();}catch(Exception e){e.printStackTrace();}}}, "1", 1 << 28).start();
		else new POGOSTICK().run();
	}
	long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
	int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
	int bit(long n){return (n==0)?0:(1+bit(n&(n-1)));}
	void p(Object o){out.print(o);}
	void pn(Object o){out.println(o);}
	void pni(Object o){out.println(o);out.flush();}
	String n()throws Exception{return in.next();}
	String nln()throws Exception{return in.nextLine();}
	int ni()throws Exception{return Integer.parseInt(in.next());}
	long nl()throws Exception{return Long.parseLong(in.next());}
	double nd()throws Exception{return Double.parseDouble(in.next());}

	class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws Exception{
			br = new BufferedReader(new FileReader(s));
		}

		String next() throws Exception{
			while (st == null || !st.hasMoreElements()){
				try{
					st = new StringTokenizer(br.readLine());
				}catch (IOException  e){
					throw new Exception(e.toString());
				}
			}
			return st.nextToken();
		}

		String nextLine() throws Exception{
			String str = "";
			try{   
				str = br.readLine();
			}catch (IOException e){
				throw new Exception(e.toString());
			}  
			return str;
		}
	}
}     