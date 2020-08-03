package YuanFuDao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/1 17:11
 * @description：
 * @modified By：
 */

public class Main1 {

    static class node{
        int t ;
        int val;

        public node(int val,int t){
            this.t = t ;
            this.val = val;
        }
    }

    public int solution(int[][] course){
        if(course.length ==0 ){
            return 0;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(course.length,
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });

        Arrays.sort(course, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        heap.add(course[0][1]);

        for(int i=1;i<course.length;i++){
            if(course[i][0] >= heap.peek()){
                heap.poll();
            }

            heap.add(course[i][1]);
        }

        return heap.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        if(count==0){
            System.out.println(0);
        }
        int[][] course = new int[count][2];
        for(int i = 0;i<count;i++){
            String line = in.nextLine();
            String[] s = line.split(" ");
            course[i][0] = Integer.parseInt(s[0]);
            course[i][1] = Integer.parseInt(s[1]);
        }
        Main1 main1 = new Main1();
        int solution = main1.solution(course);
        System.out.println(solution);
    }
}
