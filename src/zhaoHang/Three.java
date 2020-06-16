package zhaoHang;

import java.util.Arrays;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n+1];
        for(int i = 1; i <= n; i++){
            a[i] = in.nextInt();
        }

        int[] pre = new int[n+2];
        int[] suf = new int[n+2];
        int[] cnt = new int[n+2];
        Arrays.sort(a,1,a.length);
        long ans = Long.MAX_VALUE;
        for(int i = 1; i <= n; i++) pre[i] = pre[i - 1] + a[i];
        for(int i = n; i >= 1; i--) suf[i] = suf[i + 1] + a[i];
        for(int i = 1; i <= n; i++)
        {
            if(a[i] == a[i - 1]) cnt[i] = cnt[i - 1] + 1;
            else cnt[i] = 1;
            if(cnt[i] >= k){
                System.out.println(0);
                return;
            }
        }
        for(int i = 1; i <= n; i++)
        {
            if(i >= k) ans = Math.min(ans, i * a[i] - pre[i] - (i - k));
            if(n - i + 1 >= k) ans = Math.min(ans, suf[i] - (n - i + 1) * a[i] - (n - i + 1 - k));
            ans = Math.min(ans, i * a[i] - pre[i] + suf[i] - (n - i + 1) * a[i] - (n - k));
        }
        System.out.println(ans);

    }

}

