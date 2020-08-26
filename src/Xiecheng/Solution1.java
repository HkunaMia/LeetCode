package Xiecheng;

import java.util.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/15
 * \* Time: 18:56
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class Solution1 {
    static int[] road(int a,int b,int k){
        if(k==0) return new int[0];
        if(a<b){
            int temp = a;
            a = b;
            b=temp;
        }
        TreeSet<Integer> res = new TreeSet<>();
        for(int i = k;i>=0;i--){
            res.add(i * a + (k-i) *b) ;
        }
        Arrays.sort(res.toArray());
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int k = in.nextInt();
        int[] res = road(a,b,k);
        for(int i = 0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
