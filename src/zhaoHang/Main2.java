package zhaoHang;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/3 16:00
 * @description：
 * @modified By：
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int m = in.nextInt();
        int benefit = s;
        int count = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        queue.add(s);
        while (benefit < m) {
            int temp = queue.poll();
            if(temp == 1 ){
                count=-1;
                break;
            }
            int left = temp/2;
            queue.add(left);
            int right = (temp+1)/2;
            queue.add(right);
            benefit += left*right;
            count++;
        }
        System.out.println(count);
    }
}
