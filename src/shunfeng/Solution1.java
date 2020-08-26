package shunfeng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：mzr
 * @date ：Created in 2020/8/20 20:56
 * @description：
 * @modified By：
 */

public class Solution1 {
    public static int[] visited = new int[1000];

    public static int search(List<Custom> list,int bandwistd){
        for(int i = 0;i<list.size();i++){
            if(list.get(i).bandWidth == bandwistd && visited[i]==0){
                visited[i] = 1;
                return list.get(i).money;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m =in.nextInt();
        int[] w = new int[n];
        for(int i=0;i<n;i++){
            w[i] = in.nextInt();
        }
        List<Custom> list = new ArrayList<>();
        for(int i = 0;i<m;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            Custom custom = new Custom(a,b);
            list.add(custom);
        }
        Arrays.sort(w);
        list.sort((o1, o2) -> {
            if(o1.bandWidth > o2.bandWidth) return 1;
            else if(o1.bandWidth<o2.bandWidth) return -1;
            else{
                if(o1.money < o2.money) return 1;
                else if(o1.money > o2.money) return -1;
                else return 0;
            }
         });

        int all = 0;
        for(int i=0;i<n;i++){
            int money = search(list,w[i]);
            all += money;
        }
        System.out.println(all);

    }
}
class Custom{
    int bandWidth;
    int money;
    public Custom(int bandWidth,int money){
        this.bandWidth = bandWidth;
        this.money = money;
    }

}