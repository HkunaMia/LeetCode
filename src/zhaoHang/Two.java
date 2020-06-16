package zhaoHang;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] row = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            row[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(minSwapsCouples(row));
    }
    public static int minSwapsCouples(int[] row) {
        int res = 0;
        for (int i = 0; i < row.length; i += 2) {
            int t = row[i] ^ 1;
            if (row[i + 1] == t) {
                continue;
            }
            res++;
            for (int j = i + 1; j < row.length; j++) {
                if (row[j] == t) {
                    // 交换
                    row[j] = row[i + 1];
                    row[i + 1] = t;
                    break;
                }
            }
        }
        return res;
    }
}