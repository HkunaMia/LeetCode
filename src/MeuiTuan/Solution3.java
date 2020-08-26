package MeuiTuan;

import java.util.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/22
 * \* Time: 16:16
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class Solution3 {

    public static int[] getMaxValue(int n,int[] w,int[] index){
        int Max = 0;
        int[] res = new int[n];
        for(int i = 1;i<=n;i++){
            w[index[i]] = 0;
            int temp = 0;
            for(int j = 1;j<=n;j++){
                if(w[j]!=0){
                    temp+=w[j];
                }else{
                    Max = Math.max(temp,Max);
                    temp = 0;
                }
            }
            Max = Math.max(temp,Max);
            res[i-1] = Max;
            Max = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] w = new int[n+1];
        String[] s = in.nextLine().split(" ");
        for(int i=0;i<n;i++){
            w[i+1] = Integer.parseInt(s[i]);
        }
        int[] index = new int[n+1];
        String[] ss = in.nextLine().split(" ");
        for(int i= 0;i<n;i++){
            index[i+1] = Integer.parseInt(ss[i]);
        }
        int[] res = getMaxValue(n,w,index);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
