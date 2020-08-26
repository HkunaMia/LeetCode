package QiHu360;


import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/22 20:00
 * @description：
 * @modified By：
 */

public class Solution1 {

    public static boolean isTrue(String s){
        if(s.length()>10) return false;
        for(int i=0;i<s.length();i++){
            if(!Character.isLetter(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int count = 0;
        for(int i = 0;i<n;i++){
            String line = in.nextLine();
            if(isTrue(line)) count++;
        }
        System.out.println(count);
    }
}
