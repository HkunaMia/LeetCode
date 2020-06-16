package NewCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/18 16:13
 * @description：滑动窗口最大值
 * @modified By：
 */

public class stack7 {
    public static int[] getMaxWindow(int[] num,int window){
        if(num==null || window>num.length){
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[num.length-window+1];
        int index = 0;
        for(int i=0;i<num.length;i++){
            while (!queue.isEmpty() && num[i] >= num[queue.peekLast()]){
                queue.pollLast();
            }
            queue.addLast(i);
            if(queue.peekFirst() == i-window){
                queue.pollFirst();
            }
            if(i >= window-1){
                res[index++] = num[queue.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int windows = sc.nextInt();
        int[] number = new int[length];
        for(int i = 0; i<length; i++){
            number[i] = sc.nextInt();
        }
//        System.out.println(Arrays.toString(number));
        int[] res = stack7.getMaxWindow(number,windows);
        for(int j = 0;j<res.length-1;j++){
            System.out.print(res[j]+" ");
        }
        System.out.print(res[res.length-1]);
    }
}
