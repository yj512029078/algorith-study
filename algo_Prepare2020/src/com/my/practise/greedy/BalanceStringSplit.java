package com.my.practise.greedy;

public class BalanceStringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int balancedStringSplit(String s) {
        int num = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'L')
                num++;
            else
                num--;
            if(num == 0)
                res++;
        }
        return res;
    }

}
