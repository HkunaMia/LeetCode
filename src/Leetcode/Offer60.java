package Leetcode;


public class Offer60 {
//    扔色子的概率
    public double[] twoSum(int n) {
        int[][] dp = new int[n+1][6*n+1];
        for(int s = 1;s<=6;s++){
            dp[1][s] = 1;
        }
        for (int i = 2;i<n+1;i++){
            for(int j = i; j<=6*i; j++){
                for(int cur=1;cur<=6;cur++){
                    if(j-cur<i-1){
                        break;
                    }
                    dp[i][j] += dp[i-1][j-cur];
                }
            }
        }
        double total = Math.pow((double) 6,(double) n);
        double[] res = new double[5*n+1];
        for(int i = n; i<=6*n; i++){
            res[i-n] = (double)dp[n][i]/total;
        }
        return res;

    }
}
