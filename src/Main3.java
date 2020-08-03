import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/3 15:29
 * @description：
 * @modified By：
 */

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s= in.nextInt();
        int m = in.nextInt();
        int sum = 0;
        int con = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2-o1);
        queue.offer(s);
        while(!queue.isEmpty() && queue.peek() >=2){
            int max = queue.poll();
            if(max%2 ==0){
                sum+=(max/2)*(max/2);
                queue.offer(max/2);
                queue.offer(max/2);
            }else {
                sum+=(max/2) * (max/2+1);
                queue.offer(max/2);
                queue.offer(max/2+1);
            }
            con++;
            if(sum>m){
                System.out.println(con);
                return;
            }
        }
        System.out.println(-1);
    }
}
