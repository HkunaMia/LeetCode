package qiAnXin;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/16 16:21
 * @description：
 * @modified By：
 */

public class Solution2 {
    public static String[] splitWord(String[] line){
        Stack<String> stack = new Stack<>();
        LinkedList<String> undo_list = new LinkedList<>();
        for(int i=0;i<line.length;i++){
            if(!line[i].equals("redo") && !line[i].equals("undo")){
                stack.push(line[i]);
            }else if(line[i].equals("undo")){
                if(!stack.empty()){
                    undo_list.addLast(stack.pop());
                }else{
                    continue;
                }
            }else if(line[i].equals("")){
                continue;
            } else{
                if(!undo_list.isEmpty()){
                    stack.push(undo_list.removeLast());
                }else{
//                    stack.push(undo_list.getLast());
                    continue;
                }
            }
        }
        String[] res = new String[stack.size()];
        int i = stack.size()-1;
        while(!stack.empty()){
            res[i] = stack.pop();
            i--;
        }
//        res.reverse();

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        String[] strings = Solution2.splitWord(s);
        for (String string : strings) {
            System.out.print(string + " ");
        }
    }
}
