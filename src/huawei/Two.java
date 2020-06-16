package huawei;

import java.util.*;

public class Two {

    public static int[] visited;

    public long maxMoney(int size, int[][] n,int[] visited){
        long maxValue = 0;
        for(int i=0;i<n.length;i++){
            int need = n[i][0];
            int price = n[i][1];
            if(need<=size && price>maxValue && visited[i]==0){
                maxValue = price;
                visited[i] = 1;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Two two = new Two();
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[2];
        for (int i =0;i<2;i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int m = arr[0];
        int n = arr[1];
        String[] s2 = sc.nextLine().split(" ");
        int[] m_size = new int[m];
        for(int i = 0;i<m;i++){
            m_size[i] = Integer.parseInt(s2[i]);
        }
        int[][] n_size = new int[n][2];
        for (int i = 0;i<n;i++){
            String[] s3 = sc.nextLine().split(" ");
            for(int j = 0;j<2;j++){
                n_size[i][j] = Integer.parseInt(s3[j]);
            }
        }

        two.visited = new int[n];
        for(int i = 0;i<n;i++){
            two.visited[i] = 0;
        }
        int res = 0;
        for(int k =0;k<m_size.length;k++){
            res += two.maxMoney(m_size[k],n_size,two.visited);
        }

        System.out.println(res);

//        System.out.println(Arrays.toString(m_size));
//        for (int j = 0;j<n;j++){
//            System.out.println(Arrays.toString(n_size[j]));
//        }

    }
}
