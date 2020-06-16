package zhaoHang;

import java.util.*;

public class Two2 {
    public static int count = 0;

    public void swap(int[] arr, int index, int target){
        for(int i = index+1; i < arr.length; i++){
            if(arr[index+1] != target){
                if(arr[i] == target){
                    int temp = arr[index + 1];
                    arr[index+1] = target;
                    arr[i] = temp;
                    count++;
                }
            }

        }
    }
    public static void main(String[] args) {
        Two2 s = new Two2();
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int sum = 2*x;
        int[] arr = new int[sum];
        for(int i = 0 ; i < sum ; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < sum; i++){
            if(arr[i] % 2 != 0){
                s.swap(arr,i,arr[i]-1);

            }
            else{
                s.swap(arr,i,arr[i]+1);
            }
            i += 1;
        }
        System.out.println(count);
    }
}
