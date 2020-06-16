package NewCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/25 11:56
 * @description：单调栈，寻找数组元素两边小于其值的下标,数组中有重复元素
 * @modified By：
 */

public class stack8_2 {

    public static int[][] getNearLessNoRepeat(int[] arr){
        Stack<List<Integer>> stack = new Stack<>();
        int[][] res = new int[arr.length][2];

        for(int i = 0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]){
                List<Integer> popIndex = stack.pop();
//                列表中最后添加的那个索引
                int left = stack.isEmpty() ? -1:stack.peek().get(stack.peek().size()-1);
                for (Integer index : popIndex) {
                    res[index][0] = left;
                    res[index][1] = i;
                }
            }
            if(!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]){
                stack.peek().add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while(!stack.isEmpty()){
            List<Integer> popIndex = stack.pop();
            int left = stack.isEmpty() ? -1:stack.peek().get(stack.peek().size()-1);
            for (Integer index : popIndex) {
                res[index][0] = left;
                res[index][1] = -1;
            }
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
