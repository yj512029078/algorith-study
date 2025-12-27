package com.design.code;

import java.util.Arrays;

public class EraseOverlapIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int eraseOverlapIntervals(int[][] intervals) {
    	if(intervals == null || intervals.length == 0) {
    		return 0;
    	}
    	
    	// 注意下这个的写法
    	Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    	
        return 0;
    }

}
