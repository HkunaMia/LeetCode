package Leetcode;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/11 11:58
 * @description：无重复最长子串
 * @modified By：
 */

public class Select3 {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        HashMap<Character,Integer> lookBefore = new HashMap<Character,Integer>();
        int curlen = 0;
        int maxlen = 0;
        for(int i = 0;i<s.length();i++){
            curlen++;
            if(lookBefore.containsKey(s.charAt(i))){
                if(left <= lookBefore.get(s.charAt(i))){
                    curlen -= lookBefore.get(s.charAt(i)) +1 - left  ;
                    left = lookBefore.get(s.charAt(i)) + 1;
                }
            }
            lookBefore.put(s.charAt(i),i);
            maxlen = Math.max(maxlen,curlen);
        }
        return  maxlen;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int res = Select3.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
