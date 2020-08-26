package Leetcode;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/3
 * \* Time: 11:17
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class NumberOfBinarySearchTree {
    public int numTrees(int n) {
        if(n<2) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            for(int j =1;j<=n;j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
