package AiQiYi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/23 15:38
 * @description：
 * @modified By：
 */

public class Solution3 {
    public static boolean isValid(String s){
        if(s.length()%2 !=0) return false;
        Stack<Character> stack = new Stack<>();
        for (Character character : s.toCharArray()) {
            if(character=='(') stack.push(')');
            else if(character=='[') stack.push(']');
            else if(character=='{') stack.push('}');
            else if(stack.isEmpty() || character != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(isValid(s)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

    }
}
