package qiAnXin;

import IO.InputAndOutput;

import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/1
 * \* Time: 15:26
 * \* To change this template use File | Settings | File Templates.
 * \* Description:完全背包问题
 * \
 */

public class One {

    public static int Solution(int[] price,int[] value,int n,int money){
        Integer[][] dp = new Integer[n][money+1];
        for(int i =0;i<=money;i++){
            dp[0][i] = i / price[0] * value[0];
        }
        for(int i=0;i<n;i++){
            dp[i][0] = 0;
        }
        int max = 0;
        for(int i=1;i<n;i++){
            for(int j=1;j<=money;j++){
                for(int k=0;k*price[i]<=j;k++){
                    int t = k * value[i] +dp[i-1][j-k*price[i]];
                    if(t>max){
                        max=t;
                    }
                }
                dp[i][j] = max;
                max = 0;
            }
        }
        return dp[n-1][money];
    }


    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int money = Integer.parseInt(in.nextLine());
        int count = Integer.parseInt(in.nextLine());
        int[] price = new int[count];
        int[] value = new int[count];
        for(int i = 0;i<count;i++){
            String string = in.nextLine();
            String[] s1 = string.split(" ");
            price[i] = Integer.parseInt(s1[0]);
            value[i] = Integer.parseInt(s1[1]);
        }
        System.out.println(One.Solution(price,value,count,money));
    }
}
