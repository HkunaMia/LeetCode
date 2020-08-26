package QiHu360;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/22 20:31
 * @description：
 * @modified By：
 */

public class Solution22 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] s1 = in.nextLine().split(" ");
        int a=1,b=2;
        boolean now = true;
        for(int i = 0;i<m;i++){
            if(s1[i].equals("1")){
                if(now){
                    a+=2;
                }else{
                    b+=2;
                }
            }
            now = !now;
        }
        for(int i =1;i<=n;i++){
            if(i!=1) System.out.print(" ");
            int temp = 0;
            if(now){
                temp = 1;
            }
            if(((i+temp+1) &1)==1){
                a = a%n !=0 ?a%n:n;
                System.out.print(a);
                a+=2;

            }else{

                b = b%n !=0 ? b%n:n;
                System.out.print(b);
                b+=2;
            }
        }
    }


}
