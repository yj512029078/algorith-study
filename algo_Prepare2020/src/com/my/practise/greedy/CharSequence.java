package com.my.practise.greedy;

public class CharSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc"; 
		String t = "ahbgdc";
		boolean result = isSubsequence(s,  t);
		System.out.println("result: " + result);
	}
	
    public static boolean isSubsequence(String s, String t) {
    	boolean result = false;
    	
    	if((s == null) || (t == null)) {
    		return result;
    	}
    	
    	if(s.isEmpty() && t.isEmpty()) {
    		return true;
    	}
    	
    	if(s.isEmpty() && !t.isEmpty()) {
    		return true;
    	}
    	
    	int sIndex = 0;
    	int tIndex = 0;
    	while((sIndex < s.length()) && (tIndex < t.length())) {
    		if(s.charAt(sIndex) == t.charAt(tIndex)) {
    			System.out.println("temp: " + t.charAt(tIndex));
    			sIndex++;
    	 		tIndex++;
    			continue;
    		}
    		tIndex++;
    	}
    	
    	return (sIndex == s.length());
    }

}
