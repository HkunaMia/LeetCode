package zhaoHang;

import java.util.*;
//三角矩阵最长路径
public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j <= i){
                    arr[i][j] = sc.nextInt();
                    if(j == i)
                        break;
                }

            }
        }
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                arr[i][j] = Math.max(arr[i+1][j],arr[i+1][j+1]) + arr[i][j];
            }
        }
        System.out.println(arr[0][0]);
    }
}