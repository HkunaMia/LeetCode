package AiQiYi;



import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/23 14:56
 * @description：
 * @modified By：
 */

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        while(n!=0){
            count+=n/5;
            n=n/5;
        }
        System.out.println(count);
    }
}
