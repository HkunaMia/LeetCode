package Leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/10 14:51
 * @description：接雨水
 * @modified By：
 */

public class top42 {

    public static int trap(int[] height){
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        while (cur < height.length){
//            当current大于栈顶元素，栈顶出栈
            while (!stack.empty() && height[cur]>height[stack.peek()]){
                int h = height[stack.pop()];
                if(stack.empty()){
                    break;
                }
                int dis = cur - stack.peek() - 1;
                int min = Math.min(height[cur],height[stack.peek()]);
                sum += (min-h)*dis;
            }
//            当current小于栈顶元素，入栈
            stack.push(cur);
            cur++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().trim().split(" ");
        int[] arr = new int[line.length];
        for(int i=0;i<line.length;i++){
            arr[i] = Integer.parseInt(line[i]);
        }
        int trap = top42.trap(arr);
        System.out.println(trap);
    }
}
