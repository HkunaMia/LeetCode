package NewCode;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/6/1 10:54
 * @description：最大值减去最小值小于或等于num的子数组数量
 * @modified By：
 */

public class GetNum {

    public static int getNum(int[] arr,int num){
        if(arr==null || arr.length==0 || num<0 ){
            return 0;
        }
        int res = 0;
        int i = 0;
        int j = 0;
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        while(i<arr.length){
            while(j<arr.length){
                if(qmin.isEmpty() || qmin.peekLast() != j){
                    while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
                        qmin.pollLast();
                    }
                    qmin.addLast(j);
                    while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                        qmax.pollLast();
                    }
                    qmax.addLast(j);
                }
                if(arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num){
                    break;
                }
                j++;
            }
            res += j-i;
            if(qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            if(qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int num = in.nextInt();
        int[] arr = new int[size];
        for(int i = 0;i<size;i++){
            arr[i] = in.nextInt();
        }
        int res = getNum(arr,num);
        System.out.println(res);
    }
}
