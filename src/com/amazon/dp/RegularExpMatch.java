package com.amazon.dp;

public class RegularExpMatch {

	int regularExp(String str, String pattern) {
		char pat[] = pattern.toCharArray();
        char st[] = str.toCharArray();
        
        
        boolean dp[][] = new boolean[st.length+1][pat.length+1];

        dp[0][0] = true;
        
        // put true in the a*b*c* places
        for(int i = 2;i <= pat.length; i++) {
        	dp[0][i] = dp[0][i-2];
        }

        for(int i = 1; i <= st.length; i++){
            for(int j = 1; j <=  pat.length; j++){
                if(st[i-1] == pat[j-1] || pat[j-1] == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if(pat[j-1] == '*') {
                	// move back two places just to see if we remove the preceding character then it does not affect
                	dp[i][j] = dp[i][j-2];
                	
                	//check if the preceding character is . then it can be anything on the string
                	if((st[i-1] == pat[j-2]) || pat[i-1] == '.')
                		dp[i][j] = dp[i-1][j];
                } // check for up and left
            }
        }
        
        return dp[st.length][pat.length] == true ? 1 : 0;
	}
	
}
