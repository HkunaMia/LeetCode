package DIDI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/21 20:02
 * @description：
 * @modified By：
 */

public class Solution2 {

    public static long[][] criclePrint(int n,long[] dp){
        long[][] res = new long[n][n];
        int k = 0;
        for(int i = 0;i<n/2;i++){
            for(int j=i;j<n-i;j++){
                if(res[i][j] == 0){
                    res[i][j] = dp[k++];
                }
            }
            for(int j=i+1;j<n-i;j++){
                if(res[j][n-i-1]==0){
                    res[j][n-i-1] = dp[k++];
                }
            }
            for(int j = n-i-1;j>i;j--){
                if(res[n-i-1][j]==0){
                    res[n-i-1][j] = dp[k++];
                }
            }
            for(int j = n-i-1;j>i;j--){
                if(res[j][i]==0){
                    res[j][i] = dp[k++];
                }
            }
        }
        if(n%2==1) res[n/2][n/2] = dp[k];
        return res;
    }

    public static long fibonacii(int n,long[] dp){
        if(n==0) return 0;
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        dp[n] = fibonacii(n-1,dp)+fibonacii(n-2,dp);
        return dp[n];
    }

    public static long process(int n){
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
        return fibonacii(n,dp);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n==1){
            System.out.println(1);
            return;
        }
        long[] arr = new long[n*n];
        for(int i=1;i<=n*n;i++){
            arr[n*n-i] = process(i);
        }
        long[][] criclePrint = criclePrint(n, arr);
        for (long[] ints : criclePrint) {
            for(int i = 0;i<ints.length;i++){
                System.out.print(ints[i]+" ");
            }
            System.out.println();
        }
    }
}
