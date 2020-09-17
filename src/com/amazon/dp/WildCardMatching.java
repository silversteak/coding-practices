package com.amazon.dp;

public class WildCardMatching {
	
	int wildCard(String pattern, String str)
    {
        char pat[] = pattern.toCharArray();
        char st[] = str.toCharArray();
        
        /*
         * This block of code is there to remove the repitive *****79****
         */
        boolean isFirst = true;
        int wildCard = 0;
        for(int i = 0; i < pat.length; i++){
            if(pat[i] == '*'){
                if(isFirst){
                   pat[wildCard++] = pat[i];
                   isFirst = false; 
                }
            }else{
                pat[wildCard++] = pat[i];
                isFirst = true;
            }
        }
        
        boolean dp[][] = new boolean[st.length+1][wildCard+1];
        
        /*
         *the dp[0][1] will be true only if first is the star pattern -- because it can represent empty string also 
         */
        if(wildCard > 0 && pat[0] == '*')
            dp[0][1] = true;
        dp[0][0] = true;
        
        for(int i = 1; i <= st.length; i++){
            for(int j = 1; j <= wildCard; j++){
                if(st[i-1] == pat[j-1] || pat[j-1] == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(pat[j-1] == '*') {
                	/*			case 1				case 2
                	 * X?Y* -   X?Y(remove pat)		X?Y*
                	 * XaY		XaY					Xa (remove the st)
                	 */
                	dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } // check for up and left
            }
        }
        
        return dp[st.length][wildCard] == true ? 1 : 0;
        
    }

}
