package huawei;

import java.util.*;
/*
一个字符串任意删掉k个，使得其字典序最小
* */

public class Dictionary {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] charStr = str.toCharArray();
        int k = sc.nextInt();
        Stack<Character> stack = new Stack<>();
        for (int i =0;i<charStr.length;i++){
            if(stack.empty()){
                stack.push(charStr[i]);
            }else {
                if (stack.peek() < charStr[i]) {
                    stack.push((charStr[i]));
                } else {
                    while (!stack.empty() && stack.peek() > charStr[i] && k > 0) {
                        stack.pop();
                        k--;
                    }
                    stack.push(charStr[i]);
                }
            }
        }
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuffer ans = new StringBuffer();
        while (!stack.empty()){
            ans.append(stack.pop());
        }
        ans.reverse();
        System.out.println(ans);
    }

}
