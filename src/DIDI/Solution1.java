package DIDI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/21 19:47
 * @description：
 * @modified By：
 */

public class Solution1 {

    public static int helper(int n, List list){
        if(100>=n || n>=2000){
            return 0;
        }
        for(int i = 1;i<=9;i++){
            for(int j = 0;j<=9;j++){
                for(int k = 0;k<=9;k++){
                    if(i!=j && j!=k && 200*i +10*j+12*k ==n){
                        list.add(100*i + 10*j + k);
                        list.add(100*i + 11*k);
                    }
                }
            }
        }
        return list.size()/2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        int res = helper(n,list);
        System.out.println(res);
        if(res!=0){
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i));
                if(i != list.size()-1) System.out.print(" ");
            }
        }
    }
}
