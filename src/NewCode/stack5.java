package NewCode;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/18 15:01
 * @description：用一个栈实现另一个栈的排序
 * @modified By：
 */

public class stack5 {

    public static Stack<Integer> SortedByStack(Stack<Integer> stack){
        Stack<Integer> helper = new Stack<>();
        while (!stack.empty()){
            int cur = stack.pop();
            while(!helper.isEmpty() && helper.peek() < cur){
                stack.push(helper.pop());
            }
            helper.push(cur);
        }
        while(!helper.isEmpty()){
            stack.push(helper.pop());
        }

        return stack;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i =0 ;i<num;i++){
            stack.push(sc.nextInt());
        }
        Stack<Integer> res = stack5.SortedByStack(stack);
        while(!res.isEmpty()){
            System.out.print(res.pop() + " ");
        }
    }
}
