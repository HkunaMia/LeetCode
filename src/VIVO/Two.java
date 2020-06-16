package VIVO;

import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/6/7 15:19
 * @description：
 * @modified By：
 */

public class Two {

    public int superEggDrop(int K, int N) {

        int[][] dp = new int[K + 1][N + 1];

        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++)
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
        }
        return m;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();

        Two m = new Two();
        int res = m.superEggDrop(k,n);
        System.out.println(res);
    }
}
