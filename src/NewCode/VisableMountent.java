package NewCode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：mzr
 * @date ：Created in 2020/6/1 11:53
 * @description：一圈环形山中可见山峰的个数
 * @modified By：
 */

public class VisableMountent {

    public static class Record{
        public int value;
        public int times;

        public Record(int value){
            this.value = value;
            this.times = 1;
        }
    }

//    获取下一个坐标
    public static int nextIndex(int index,int size){
        return index <(size-1) ? index + 1 : 0;
    }

    public static int getInternalNum(int k){
        return k ==1 ? 0 : (k*(k-1)/2);
    }

    public static int getVisableNum(int[] arr){
        if(arr ==null || arr.length<2){
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
//        找到最大山峰的位置
        for (int i =0;i<size;i++){
            maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
        }
//        把最大的山峰放到栈里
        Stack<Record> stack = new Stack<>();
        stack.push(new Record(arr[maxIndex]));
        int nextIndex = nextIndex(maxIndex,size);
        int res = 0;
        while(nextIndex != maxIndex){
            while(stack.peek().value < arr[nextIndex]){
                int k = stack.pop().times;
                res += getInternalNum(k) + 2*k;
            }
//            与栈顶数字相同就合并
            if(stack.peek().value == arr[nextIndex]){
                stack.peek().times++;
            }else{
                stack.push(new Record(arr[nextIndex]));
            }
            nextIndex = nextIndex(nextIndex,size);
        }
//        清算栈中剩余
        while(stack.size()>2){
//            第一阶段
            int times = stack.pop().times;
            res += getInternalNum(times) + 2*times;
        }
//        第二阶段
        if(stack.size()==2){
            int times = stack.pop().times;
            res += getInternalNum(times) + (stack.peek().times == 1 ? times : 2*times);
        }

//        第三阶段
        res += getInternalNum(stack.pop().times);
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] arr = new int[size];
        for(int i = 0;i<size;i++){
            arr[i] = in.nextInt();
        }
        System.out.println(getVisableNum(arr));
    }
}

