package QiHu360;

import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/24 11:05
 * @description：
 * @modified By：
 */

public class Main2 {

    static int res = 0;

    public static void getMaxValue(int[][] matrix,int n,int m){
        int value = 0;
        int count = 0;
        for(int i = 0;i<n;i++){
            backtrace(matrix[i],value,count);
        }
    }

    public static void backtrace(int[] mm,int value,int count){
        if(count>mm.length){
            return;
        }
        if(count==mm.length){
            res = Math.max(res,value);
            return;
        }
        for(int i = 0;i<mm.length;i++){
            backtrace(mm,value+mm[i],count+i+1);
        }
    }

    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        String[] s =in.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] matrix = new int[n][m];
        for(int i = 0;i<n;i++){
            String[] ss = in.nextLine().split(" ");
            for(int j = 0;j<m;j++){
                matrix[i][j] = Integer.parseInt(ss[j]);
            }
        }
        int value = 0;
        int count = 0;
        getMaxValue(matrix,n,m);
        System.out.println(res);
    }
}
