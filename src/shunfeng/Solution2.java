package shunfeng;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/20 20:13
 * @description：
 * @modified By：
 */

public class Solution2 {

    public static int getValue(int[][] mession,int n){
        int[] pre = new int[n];
        int[] option = new int[n];
        for(int i = n-1;i>=0;i--){
            pre[i] = -1;
            for(int j = i-1;j>=0;j--){
                if(mession[j][1] <= mession[i][0]){
                    pre[i] = j;
                    break;
                }
            }
        }
        option[0] = mession[0][2];
        for(int i = 1;i<n;i++){
            int val;
            if(pre[i] == -1){
                val = 0 + mession[i][2];
            }else{
                val = option[pre[i]] + mession[i][2];
            }
            option[i] = Math.max(val,option[i-1]);
        }
        return option[n-1];
//        int value = 0;
//        for(int i = 0;i<mession.length;i++){
//            int end = mession[i][1];
//            int temp = mession[i][2];
//            for(int j = i+1;j<mession.length;j++){
//                if(mession[j][0]>end){
//                    temp += mession[j][2];
//                    end = mession[j][1];
//                }
//            }
//            value = Math.max(value,temp);
//
//        }
//        return value;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[][] mession = new int[n][3];
        for(int i= 0;i<n;i++){
            String[] strings = in.nextLine().split(" ");
            for(int j = 0;j<3;j++){
                mession[i][j] = Integer.parseInt(strings[j]);
            }
        }
        Arrays.sort(mession,(a,b)-> a[1]-b[1]);
        System.out.println(Solution2.getValue(mession,n));

    }
}
