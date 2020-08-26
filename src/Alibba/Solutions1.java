package Alibba;

import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/12
 * \* Time: 9:07
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class Solutions1 {

    //        求二进制书中1的个数
    private static int countBit(int num){
        int count = 0;
        for(; num > 0; count++)
        {
            num &= (num - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            int num = sc.nextInt();
            int weight = countBit(num);

            int end = (int)Math.pow(2,Integer.toBinaryString(num).length()-1);
            int k = num;
            int maxWeight = 0;
            int res = k;
            while(k>=end)
            {
                if(countBit(k) >= maxWeight){
                    maxWeight = countBit(k);
                    res = k;
                }
                k--;
            }
            System.out.println(res);
        }
        sc.close();


    }
}
