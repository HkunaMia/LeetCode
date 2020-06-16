package DataStructure;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/10 9:17
 * @description：堆的实现
 * @modified By：
 */


public class Heap {
    private int[] a; // 数组，从下标1开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

//    往堆中插入一个元素和删除堆顶元素的时间复杂度都是 O(logn)
    public void insert(int data) {
        if (count >= n) return; // 堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]) { // 自下往上堆化
            swap(a, i, i/2); // swap()函数作用：交换下标为i和i/2的两个元素
            i = i/2;
        }
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }


    public void removeMax() {
        if (count == 0) return; // 堆中没有数据
        a[1] = a[count];//交换堆顶与最后一个元素
        --count;
        heapify(a, count, 1);
    }

    private void heapify(int[] a, int n, int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

// 建堆的时间复杂度就是 O(n)
    private void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }


    // n表示数据的个数，数组a中的数据从下标1到n的位置。
    // 建堆过程的时间复杂度是 O(n)，排序过程的时间复杂度是 O(nlogn)。
    // 所以，堆排序整体的时间复杂度是 O(nlogn)
    // 堆排序不是稳定的排序算法
    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }


}
