package Leetcode;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/18
 * \* Time: 10:11
 * \* To change this template use File | Settings | File Templates.
 * \* Description:单调栈：求两侧最小（单调栈内满足从顶到底单调递减，如果是求两侧最大，则相反）
 * \
 */

public class SimpleStack {
    public int[][] getNearLessNoRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                int popIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 :stack.peek();
                res[popIndex][0] = leftIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftIndex = stack.isEmpty() ? -1:stack.peek();
            res[popIndex][0] = leftIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

    public int[][] getNearLess(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for(int i= 0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]){
                List<Integer> pops = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
                for(Integer pop : pops){
                    res[pop][0] = leftIndex;
                    res[pop][1]  = i;
                }
                if(!stack.isEmpty() && arr[i] == stack.peek().get(0)){
                    stack.peek().add(Integer.valueOf(i));
                }else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    stack.push(list);
                }
            }
        }
        while (!stack.isEmpty()){
            List<Integer> pops = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
            for (Integer pop : pops) {
                res[pop][0] = leftIndex;
                res[pop][1]  = -1;
            }
        }
        return res;
    }
 }
