package com.recursion;

import java.util.ArrayList;
import java.util.List;

class PalindromePartiotion {
    
    public static List<List<String>> res;
    public static List<String> list;
    
    public static List<List<String>> partition(String s) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        int len = s.length();
        dfs(s,0,len);
        return res;
        
    }
    
    public static void dfs(String s, int left, int right){      
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
    
    public static boolean isPal(String s, int low, int high){
        while(low<high) if(s.charAt(low++)!=s.charAt(high--)) return false;
        return true;
    }
    
    public static void main(String []args) {
    	partition("dab");
    	
    	for(List<String> list : res) {
    		System.out.println(list);
    	}
    	
    }
    
    
}