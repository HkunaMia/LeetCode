package Leetcode;

import java.util.*;

public class offer57 {

    public int[] twoSum(int[] nums, int target) {
//        自增数组中找到和为target的两个数
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int summ = nums[left]+nums[right];
            if(target==summ){

                return new int[]{nums[left],nums[right]};
            }
            else if(target>summ){
                left++;
            }
            else{
                right--;
            }
        }
        return new int[0];
    }

    public int[][] findContinuousSequence(int target){
//        滑动窗口找连续子数组和和为target
        int i=1;
        int j=1;
        int temp = 0;
        List<int[]> res = new ArrayList<>();

        while(i <= target/2){
            if(temp<target){
                temp+=j;
                j++;
            }
            else if(temp>target){
                temp-=i;
                i++;
            }
            else{
                int[] arr = new int[j-i];
                for(int k = i;k<j;k++){
                    arr[k-i] = k;
                }
                res.add(arr);
                temp-=i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int tagert = sc.nextInt();
        int[] arrs = new int[str.length];
        for(int i = 0;i<str.length;i++){
            arrs[i] = Integer.parseInt(str[i]);
        }
        offer57 offer57 = new offer57();
        int[] res = offer57.twoSum(arrs,tagert);
        System.out.println(Arrays.toString(res));
    }
}
