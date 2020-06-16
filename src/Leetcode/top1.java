package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class top1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i<nums.length;i++){
            int com = target-nums[i];
            if(map.containsKey(com)){
                return new int[]{map.get(com),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no such numbers");
    }
}
