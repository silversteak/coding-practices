package arrays;

import java.util.*;
import java.io.*; 
import java.text.*;
//Solution Credits: Taranpreet Singh
public class Main{
	//SOLUTION BEGIN
	void solve(int TC) throws Exception{
		int n = ni(), m = ni(), k = ni();
		int[] a = new int[2*n];
		for(int i = 0; i< n; i++)a[i] = a[n+i] = ni();
		SegTree t = new SegTree(a);
		int pos = 0;
		String s = n();
		for(int i = 0; i< s.length(); i++){
			if(s.charAt(i)=='!')pos = (pos+n-1)%n;
			else pn(Math.min(k, t.query(pos, pos+n-1)));
		}
	}
	class SegTree{
		int m = 1;
		Node[] tr;
		public SegTree(int[] ar){
			while(m<ar.length)m<<=1;
			tr = new Node[2*m];
			for(int i = m; i< ar.length+m; i++)tr[i] = new Node(ar[i-m],ar[i-m],ar[i-m],(ar[i-m]==0));
			for(int i = m+ar.length; i< 2*m; i++)tr[i] = new Node(0,0,0,true);
			for(int i = m-1; i> 0; i--)tr[i] = merge(tr[i<<1], tr[i<<1|1]);
		}
		int query(int l, int r){
			return query(l, r, 0, m-1, 1).max;
		}
		Node query(int l, int r, int ll, int rr, int i){
			if(l==ll && r==rr)return tr[i];
			int mid = (ll+rr)>>1;
			if(r<=mid)return query(l,r,ll,mid,i<<1);
			else if(l>mid)return query(l,r,mid+1,rr,i<<1|1);
			else return merge(query(l,mid,ll,mid,i<<1), query(mid+1,r,mid+1,rr,i<<1|1));
		}
	}
	Node merge(Node left, Node right){
		if(!left.split && !right.split)return new Node(left.le+right.le, left.ri+right.ri, left.max+right.max, false);
		else if(!left.split)return new Node(left.le+right.le, right.ri, Math.max(left.ri+right.le, Math.max(left.max, right.max)), true);
		else if(!right.split)return new Node(left.le, left.ri+right.ri, Math.max(left.ri+right.le, Math.max(left.max, right.max)), true);
		else return new Node(left.le, right.ri, Math.max(left.ri+right.le, Math.max(left.max, right.max)), true);
	}
	class Node{
		int le, ri, max;boolean split;
		public Node(int L, int R, int M, boolean t){
			le=L;ri=R;max=M;split = t;
		}
	}
	//SOLUTION END
	long mod = (long)1e9+7, IINF = (long)1e17;
	final int MAX = (int)20001, INF = (int)2e9, root = 3;
	DecimalFormat df = new DecimalFormat("0.000000000");
	double PI = 3.1415926535897932384626433832792884197169399375105820974944, eps = 1e-8;
	static boolean multipleTC = false, memory = false;
	FastReader in;PrintWriter out;
	void run() throws Exception{
		in = new FastReader();
		out = new PrintWriter(System.out);
		int T = (multipleTC)?ni():1;
		//Solution Credits: Taranpreet Singh
		for(int i = 1; i<= T; i++)solve(i);
		out.flush();
		out.close();
	}
	public static void main(String[] args) throws Exception{
		if(memory)new Thread(null, new Runnable() {public void run(){try{new Main().run();}catch(Exception e){e.printStackTrace();}}}, "1", 1 << 28).start();
		else new Main().run();
	}
	long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
	int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
	int bit(long n){return (n==0)?0:(1+bit(n&(n-1)));}
	void p(Object o){out.print(o);}
	void pn(Object o){out.println(o);}
	void pni(Object o){out.println(o);out.flush();}
	String n(){return in.next();}
	String nln(){return in.nextLine();}
	int ni(){return Integer.parseInt(in.next());}
	long nl(){return Long.parseLong(in.next());}
	double nd(){return Double.parseDouble(in.next());}

	class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws Exception{
			br = new BufferedReader(new FileReader(s));
		}

		String next(){
			while (st == null || !st.hasMoreElements()){
				try{
					st = new StringTokenizer(br.readLine());
				}catch (IOException  e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		String nextLine(){
			String str = "";
			try{    
				str = br.readLine();
			}catch (IOException e){
				e.printStackTrace();
			}   
			return str;
		}
	}
}      