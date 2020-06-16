package VIVO;

import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/6/7 15:19
 * @description：
 * @modified By：
 */

public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i = 0;i<n;i++){
            num[i] = sc.nextInt();
        }
        int con=0;
        for(int i = 0;i<n-1;i++){
            if(num[i] == 0 && num[i+1] ==0 ){
                num[i] = i;
                con++;
                i++;
            }
            else if(num[i] == 1){
                i++;
            }
        }
        if(n >=2 && num[n-2] ==0 && num[n-1] ==0 ){
            num[n-1] =1;
            con++;
        }
        System.out.println(con);
    }
}
