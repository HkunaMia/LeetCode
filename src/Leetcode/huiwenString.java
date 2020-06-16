package Leetcode;

import java.util.Scanner;


//最长回文子串

public class huiwenString {

    public String longestPalindrome(String s) {
        if(s == null || s.length()==0){
            return "";
        }

        int strlen = s.length();
        int maxLen = 0;
        int maxStart = 0;
        int maxEnd = 0;
        boolean[][] dp = new boolean[strlen][strlen];

        for(int r = 1;r<strlen;r++){
            for(int l = 0;l<r;l++){
                if(s.charAt(l) == s.charAt(r) && (r-l<=2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(r-l+1 > maxLen){
                        maxLen = r-l+1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }

        return s.substring(maxStart,maxEnd+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        huiwenString huiwenString = new huiwenString();
        String res = huiwenString.longestPalindrome(s);
        System.out.println(res);
    }
}
