package ChuBao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/25
 * \* Time: 20:19
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class Main3 {

    public static int getMinTime(int[] time,int n){
        Arrays.sort(time);
        int[] dp = new int[n];
        dp[0] = time[0];
        dp[1] = time[1];
        for(int i = 2;i<n;i++){
            dp[i] = Math.min(dp[i-1]+time[0]+time[i],dp[i-2]+time[0]+2*time[1]+time[i]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] time = new int[n];
        String[] s = in.nextLine().split(" ");
        for(int i = 0;i<n;i++){
            time[i] = Integer.parseInt(s[i]);
        }
        int m = Integer.parseInt(in.nextLine());
        int minTime = getMinTime(time, n);
        if(minTime<=m){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
