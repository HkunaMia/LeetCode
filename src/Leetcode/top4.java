package Leetcode;

import java.util.*;

//两个有序数组找到中位数
public class top4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = (m+n)/2;
        if( (m+n)%2 ==1 ){
            return findKth(nums1,0,m-1,nums2,0,n-1,k+1);
        }else{
            double left = findKth(nums1,0,m-1,nums2,0,n-1,k);
            double right = findKth(nums1,0,m-1,nums2,0,n-1,k+1);
            return (left+right)/2;
        }
    }

    public double findKth(int[] num1, int start1, int end1, int[] num2 ,int start2, int end2,int k){

        int m = end1-start1+1;
        int n = end2-start2+1;
        if(m>n){
            return findKth(num2,start2,end2,num1,start1,end1,k);
        }
        if(m==0){
            return num2[start2+k-1];
        }
        if(k==1){
            return Math.min(num1[start1],num2[start2]);
        }

        int na = Math.min(k/2,m);
        int nb = k-na;
        int va = num1[start1+na-1];
        int vb = num2[start2+nb-1];
        if(va==vb){
            return va;
        }
        else if(va<vb){
            return findKth(num1,start1+na,end1,num2,start2,start2+nb-1,k-na);
        }else{
            return findKth(num1,start1,start1+na-1,num2,start2+nb,end2,k-nb);
        }
    }

    public static void main(String[] args) {
        top4 top4 = new top4();
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().trim().split(" ");
        int[] num1 = new int[s1.length];
        for (int i=0;i<s1.length;i++){
            num1[i] = Integer.parseInt(s1[i]);
        }
        String[] s2 = sc.nextLine().trim().split(" ");
        int[] num2 = new int[s2.length];
        for (int i=0;i<s2.length;i++){
            num2[i] = Integer.parseInt(s2[i]);
        }
        double res  = top4.findMedianSortedArrays(num1,num2);
        System.out.println(res);
    }
}
