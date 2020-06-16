package NewCode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/25 11:56
 * @description：单调栈，寻找数组元素两边小于其值的下标
 * @modified By：
 */

public class stack8 {

    public static int[][] getNearLessNoRepeat(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[][] res = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int popIndex = stack.pop();
                int left = stack.isEmpty() ? -1:stack.peek();
                res[popIndex][0] = left;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int popIndex = stack.pop();
            int left = stack.isEmpty() ? -1:stack.peek();
            res[popIndex][0] = left;
            res[popIndex][1] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i = 0 ;i<num;i++ ){
            arr[i] = in.nextInt();
        }
        int[][] res = getNearLessNoRepeat(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i][0]).append(" ").append(res[i][1]).append('\n');
        }
        System.out.print(sb);
    }

}
