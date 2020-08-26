package qiAnXin;

import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/16 14:41
 * @description：
 * @modified By：
 */

public class Solution1 {
    public static int CalulateMethodCount (int num_money) {
        // write code here
//        int[] dp = new int[num_money+1];
//        if(num_money<2){
//            return 1;
//        }
//        dp[0] = 1;
//        dp[1] = 1;
//        for(int i = 2;i<=num_money;i++){
//            for(int j = 0;j<i;j++){
//                dp[i] += dp[j];
//            }
//        }
//        return dp[num_money];
//        if(num_money == 1){
//            return 1;
//        }else{
//            return 2 * CalulateMethodCount(num_money-1);
//        }
        if(num_money<1) return 0;
        int[] dp = new int[num_money+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4;i<=num_money;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[num_money];
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        System.out.println(Solution1.CalulateMethodCount(i));
    }
}
