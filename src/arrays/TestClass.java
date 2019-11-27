package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestClass {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String strArray[] = str.split("\\s");
		int n = Integer.parseInt(strArray[0]);
		int m = Integer.parseInt(strArray[1]);
		int ans = 0;
		char [][] grid = new char [n][m];

		for(int i = 0; i < n; i++ ) {
			grid[i] = (br.readLine()).toCharArray();
		}

		for(int i=3;i< n;i++)
			for(int j=0;j< m-3;j++)
				if(check(grid[i][j],grid[i-1][j+1],grid[i-2][j+2],grid[i-3][j+3]))
					ans++;
		for(int i=0;i< n-3;i++)
			for(int j=0;j< m-3;j++)
				if(check(grid[i][j],grid[i+1][j+1],grid[i+2][j+2],grid[i+3][j+3]))
					ans++;
		for(int i=0; i< n;i++)
			for(int j=0; j< m-3;j++)
				if(check(grid[i][j],grid[i][j+1],grid[i][j+2],grid[i][j+3]))
					ans++;
		for(int i=0; i< n-3;i++)
			for(int j=0; j< m;j++)
				if(check(grid[i][j],grid[i+1][j],grid[i+2][j],grid[i+3][j]))
					ans++;

		System.out.println(grid[0][0]);
		
		System.out.println(ans);



	}

	private static boolean check(char c, char d, char e, char f) {
		if(c=='s' && d=='a' && e=='b' && f=='a')
			return true;
		return false;

	}

}
