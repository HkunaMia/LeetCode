package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/31 11:16
 * @description：安排多个会议，如何安排用到最少的会议室
 * @modified By：
 */

public class meetingRoom {

    public int minMeetingRooms(int[][] intervals) {

        if(intervals.length ==0 ){
            return 0;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(intervals.length,
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        heap.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >= heap.peek()){
                heap.poll();
            }

            heap.add(intervals[0][1]);
        }

        return heap.size();
    }
}
