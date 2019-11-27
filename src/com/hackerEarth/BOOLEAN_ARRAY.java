package com.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOOLEAN_ARRAY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FastReader in = new FastReader();
			int t = in.nextInt();
			while(t-->0) {
				int m = in.nextInt();
				int n = in.nextInt();
				int mat [][] = new int[m][n];
				for(int i = 0; i < m; i++) {
					for(int j = 0; j < n; j++) {
						mat[i][j] = in.nextInt();
					}
				}
				
				/*int row[ ]= new int [m]; 
		        int i, j; 
		      
		        for (i = 0; i < m; i++) { 
					row[i] = 0; 
		        } 
		      
		      
		        for (i = 0; i < n; i++) { 
					col[i] = 0; 
		        } 
		        
		        Arrays.fill(row, 0);
			  for (i = 0; i < m; i++) { 
		            for (j = 0; j < n; j++) { 
		                if (mat[i][j] == 1) { 
		                    row[i] = 1;  
		                } 
		            } 
		        } 
		      
		        for (i = 0; i < m; i++) { 
		            for (j = 0; j < n; j++) { 
		                if ( row[i] == 1){ 
		                    mat[i][j] = 1; 
		                } 
		            } 
		        }*/
	/*			
				boolean flag = false; 
		        for (int i = 0; i < m; i++ ){ 
		                for (int j = 0; j < n; j++){ 
		                        if (i == 0 && mat[i][j] == 1) 
		                            flag = true; 
		                       
		                        if (mat[i][j] == 1){  
		                            mat[i][0] = 1; 
		                        } 
		                          
		                    } 
		                } 
		                  
		        for (int i = 1; i < m; i ++){ 
		                for (int j = 1; j < n; j ++){           
		                    if (mat[0][j] == 1 || mat[i][0] == 1){ 
		                            mat[i][j] = 1; 
		                        } 
		                    } 
		                } 
		                 
		        if (flag == true){ 
		            for (int i = 0; i < n; i++){ 
		                        mat[0][i] = 1; 
		                    } 
		                } */
				
				
				HashSet<Integer> myHash = new HashSet<>();
 				
				for (int i = 0; i < m; i++) { 
		            for (int j = 0; j < n; j++) { 
		                if (mat[i][j] == 1) { 
		                      myHash.add(i);
		                } 
		            } 
		        } 
				
				for(int i = 0; i < m; i++) {
					if(myHash.contains(i)) {
						Arrays.fill(mat[i], 1);
					}
				}
		        
		        for (int i = 0; i < m; i++) { 
		            for (int j = 0; j < n; j++) { 
		            	System.out.print(mat[i][j] + " ");
		            } 
		            System.out.println();
		        }
		       
		        //System.out.println();
		       
			}
	
		}catch(Exception e ) {
			
		}

	}
	
	
	static class FastReader{ 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader(){ 
			br = new BufferedReader(new InputStreamReader(System.in)); 
		} 

		String next() { 
			while (st == null || !st.hasMoreElements()){ 
				try{ 
					st = new StringTokenizer(br.readLine()); 
				}catch (IOException  e){ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() { 
			return Integer.parseInt(next()); 
		} 

		long nextLong(){ 
			return Long.parseLong(next()); 
		} 

		double nextDouble(){ 
			return Double.parseDouble(next()); 
		} 

		String nextLine(){ 
			String str = ""; 
			try{ 
				str = br.readLine(); 
			} 
			catch (IOException e) { 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	} 

}
