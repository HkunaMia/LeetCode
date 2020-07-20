package DataStructure;

import IO.InputAndOutput;

import java.util.Random;
import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/20
 * \* Time: 16:33
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class MySort {

    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void quickSort(int[] a,int low,int high){
        if(low>=high){
            return;
        }
        int p  = partition(a,low,high);
        quickSort(a,low,p-1);
        quickSort(a,p+1,high);
    }

    public int partition(int[] a,int low,int high){
        int key = a[low];

        while(low<high){
            while(high>low && a[high]>=key){
                high--;
            }
            a[low] = a[high];
            while(high>low && a[low]<=key){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }

    public void mergeSort(int[] a,int low,int high,int[] temp){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(a,low,mid,temp);
            mergeSort(a,mid+1,high,temp);
            merge(a,low,mid,high,temp);
        }
    }

    public void merge(int[] a ,int low, int mid,int high,int[] temp){
        int i = 0;
        int j = low,k =mid+1;
        while (j<=mid && k<=high){
            if(a[j]<a[k]){
                temp[i++] = a[j++];
            }else {
                temp[i++] =a [k++];
            }
        }
        while(j<mid){
            temp[i++] = a[j++];
        }
        while(k<high){
            temp[i++] =a [k++];
        }
        for(int t=0;t<i;t++){
            a[low+t] = temp[t];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nums = in.nextLine();
        int[] arrs = InputAndOutput.stringToIntegerArray(nums);
        MySort mySort = new MySort();
        int[] temp = new int[arrs.length];
//        mySort.mergeSort(arrs,0,arrs.length-1,temp);
        mySort.quickSort(arrs,0,arrs.length-1);
        System.out.println(InputAndOutput.integerArrayToString(arrs));
    }
}
