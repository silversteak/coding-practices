package com.amazon.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PallindromicPartition {

	List<List<String>> res;
    List<String> list;
    
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        int len = s.length();
        dfs(s,0,len);
        return res;
        
    }
    
    public void dfs(String s, int left, int right){
        
        if(left == right){
            res.add(new ArrayList<String>(list));
        }
        else{
            for(int pos = left; pos < right; pos++){
                if(isPal(s,left,pos)){
                     list.add(s.substring(left,pos+1));
                     dfs(s,pos+1,right);
                     list.remove(list.size()-1);
                }   
            }
        }
        
    }
    
    public boolean isPal(String s, int low, int high){
        while(low<high) if(s.charAt(low++)!=s.charAt(high--)) return false;
        return true;
    }
    
	
}
