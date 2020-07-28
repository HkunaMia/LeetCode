package DataStructure;

import IO.InputAndOutput;
import Leetcode.IO_input_output;

import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/20
 * \* Time: 14:52
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class Myheap {
//    用数组存储堆元素
    private int[] a;
//    最大容量
    private int n;
//    目前已储存的容量
    private int count;

    public Myheap(int capacity){
//        index=0的位置不存元素
        a = new int[capacity+1];
        n = capacity;
        count = 0;
    }

    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

//    向堆中插入元素
    public void insert(int data){
        if(count==n){
//            已满就返回
            return;
        }
        ++count;
//        将元素放在数组末尾
        a[count] = data;
        int i = count;
//        进行调整
        while(i/2 > 0 && a[i]>a[i/2]){
            swap(a,i,i/2);
            i = i/2;
        }
    }

//    删除最大的元素，即堆顶元素
    public void removeMax(){
        if(count==0){
            return;
        }
        a[1] = a[count];
        --count;
        heapfiy(a,count,1);
    }

//    一次堆化
    private void heapfiy(int[] a,int n,int i){
        while(true){
            int maxPos = i;
            if(2*i <=n && a[i]<a[2*i]){
                maxPos = 2*i;
            }
            if(2*i+1 <=n && a[maxPos]<a[2*i+1]){
                maxPos = 2*i+1;
            }
            if(maxPos == i){
                break;
            }
            swap(a,maxPos,i);
            i = maxPos;
        }
    }

//    使用数组建堆
    public void buildHeap(int[] a ,int n){
        for(int i = n/2;i>=1;i--){
            heapfiy(a,n,i);
        }
    }

//    堆排序
    public void sort(int[] a ,int n){
        buildHeap(a,n);
        int k = n;
        while(k>1){
//            把最大的放到数组的最后面，然后对前面的进行堆化
            swap(a,1,k);
            --k;
            heapfiy(a,k,1);
        }
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int[] arrs = new int[n+1];
        for(int i = 1;i<n+1;i++){
            arrs[i] = in.nextInt();
        }
        Myheap myheap = new Myheap(n);
        myheap.sort(arrs,n);
        System.out.println(InputAndOutput.integerArrayToString(arrs));

    }
}
