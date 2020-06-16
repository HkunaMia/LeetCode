package tenxun;

import java.util.Scanner;

public class tenxunTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        double[] ans = new double[k];
        for (int l = 0; l < k; l++) {
            int n = in.nextInt();
            int[][] a = new int[n][2];
            int[][] b = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = in.nextInt();
                a[i][1] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i][0] = in.nextInt();
                b[i][1] = in.nextInt();
            }
            double min = Double.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double temp = Math.pow((a[i][0] - b[j][0]), 2) + Math.pow((a[i][1] - b[j][1]), 2);
                    min = min > temp ? temp : min;
                }
            }
            ans[l] = Math.sqrt(min);
        }
        in.close();
        for (int l = 0; l < k; l++) {
            System.out.printf("%.3f\n" , ans[l]);
        }
    }
}
