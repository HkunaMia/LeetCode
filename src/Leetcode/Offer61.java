package Leetcode;

import java.util.*;

//从扑克牌中随机抽五张，看看是不是顺子


public class Offer61 {

    public boolean isStraight(int[] nums){
        Set<Integer> set = new HashSet<>();
        int max = 0,min = 14;
        for (int num : nums) {
            if(num==0)  continue;
            max = Math.max(max,num);
            min = Math.min(min,num);
            if(set.contains(num)) return false;
            set.add(num);
        }
        return max - min<5;
    }

    public static void main(String[] args) {
        Offer61 offer61 = new Offer61();
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] num = new int[s.length];
        for (int i=0;i<s.length;i++){
            num[i] = Integer.parseInt(s[i]);
        }
        boolean straight = offer61.isStraight(num);
        System.out.println(straight);
    }
}
