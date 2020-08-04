package Leetcode;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/3
 * \* Time: 10:42
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class RobotPath {
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        int[][] dp = new int[m][n];
        for(int j=0;j<n;j++){
            dp[0][j] = 1;
        }
        for(int i =0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j] +dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
