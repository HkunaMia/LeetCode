package Shopee;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/7/28 22:08
 * @description：
 * @modified By：
 */

public class Problem2 {

    public class treeNode{
        public int val;
        public treeNode left;
        public treeNode right;

        public treeNode(int data){
            this.val = data;
        }
    }

    public treeNode buildTree(int[] input){
        if(input.length == 0) return null;
        treeNode node = new treeNode(input[0]);
        int index = 1;
        while (input[index]<node.val){
            index++;
        }
        int[] left = Arrays.copyOfRange(input,1,index);
        int[] right = Arrays.copyOfRange(input,index,input.length);
        node.left = buildTree(left);
        node.right = buildTree(right);
        return node;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
//        这里切割的时候，省去了两头的方括号
//        input = input.substring(1, input.length() - 1);

        if (input.length() == 0) {
            return new int[0];
        }

//        以逗号分隔
        String[] parts = input.split(",");
//        以空格分隔
//        String[] parts = input.split(" ");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    //    int数组转string输出
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        for(int index = 0; index < length; index++) {
            int number = nums[index];
//            连接并加逗号
            result.append(Integer.toString(number)).append(", ");
        }

//        切掉最后一个数添加的“， ”，再加括号
        return result.substring(0, result.length() - 2);
    }

    public static String integerArrayToString(int[] nums) {

        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String input = in.nextLine();
        int[] ints = stringToIntegerArray(input);
    }
}
