package QiHu360;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/22 20:10
 * @description：
 * @modified By：
 */

public class Solution2 {

    public static List<Integer> operations(int n, int m, String[] s1){
        LinkedList<Integer> res = new LinkedList<>();
        for(int i=0;i<n;i++){
            res.addLast(i+1);
        }
        for (String s : s1) {
            if(s.equals("1")){
                res.addLast(res.pollFirst());
            }
            if(s.equals("2")){
                for(int i=0;i<n-1;i=i+2){
                    int temp = res.get(i);
                    res.set(i,res.get(i+1));
                    res.set(i+1,temp);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] s1 = in.nextLine().split(" ");
        List<Integer> operations = operations(n, m, s1);
        for(int i=0;i<n;i++){
            System.out.print(operations.get(i)+" ");
        }
    }
}
