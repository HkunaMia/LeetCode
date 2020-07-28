package DataStructure;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/21
 * \* Time: 11:00
 * \* To change this template use File | Settings | File Templates.
 * \* Description:二分查找
 * \
 */

public class BinarySearch {
//    查找第一个值等于给定值
    public int bSearchFirst(int[] a,int target){
        int low = 0;
        int high = a.length-1;
        while (low<=high){
            int mid = low +((high-low)>>1);
            if(a[mid]>target){
                high = mid-1;
            }else if(a[mid]<target){
                low = mid+1;
            }else{
                if(mid==0 || a[mid-1]<target) return mid;
                else high = mid-1;
            }
        }
        return -1;
    }

//    查找最后一个值等于给定值的元素

    public int bSearchLast(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

//    查找第一个大于等于给定值的元素
    public int bSearchFirstLarger(int[] a, int n, int value){
        int low = 0;
        int high = n - 1;
        while(low<=high){
            int mid =  low + ((high - low) >> 1);
            if(a[mid]>value){
                if(mid==0 || a[mid-1]<value) return mid;
                else high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

//    查找最后一个小于等于给定值的元素

    public int bSearchFirstSamller(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }
}
