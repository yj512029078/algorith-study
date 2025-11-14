package com.design.code.dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "abcde";
		String text2 = "ace";
		int result = longestCommonSubsequence(text1, text2);
		System.out.println(result);
	}
	
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // dp[i][j] = text1前i个字符 和 text2前j个字符 的LCS长度
        int[][] dp = new int[m + 1][n + 1];
        
        // 初始化第一行和第一列为0（已经是默认值）
        // dp[0][j] = 0 表示 text1为空
        // dp[i][0] = 0 表示 text2为空
        
        // 填表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 注意：dp[i][j] 对应 text1[i-1] 和 text2[j-1]
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 情况1：字符相同
                    // LCS长度 = 前面的LCS + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 情况2：字符不同
                    // 跳过其中一个字符，取较大的
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // 返回右下角的值
        return dp[m][n];
    }

}
