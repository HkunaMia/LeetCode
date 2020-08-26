package WangYi;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Try {


    public static int findTime(int[][] table){
        Stack<int[]> stack = new Stack<>();
        int[] time = new int[table.length/2 + 1];
        int[] visited  = new int[table.length/2 + 1];
        for(int i = 0;i<table.length;i++){
            if(table[i][2] == 0){
                int[] t  = {table[i][0],table[i][1]};
                stack.push(t);
                visited[table[i][1]] = i+1;
            }else{
                int[] pop = stack.pop();
                if(visited[pop[1]] != 0){
                    int distance = i - visited[pop[1]];
                    int totle = table[i][0] - pop[0];
                    if(distance == 0){
                        time[pop[1]] = totle;
                    }
                    else{
                        for(int j = 1;j<visited.length;j++){
                            if(visited[j] > visited[pop[1]]){
                                totle -= time[j];
                            }
                        }
                        time[pop[1]] = totle;
                    }

                }
            }
        }
        int res = 0;
        int index = 0;
        for(int i =1;i<time.length;i++){
            if(res<time[i]){
                res = time[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for(int i = 0;i<count;i++){
            int n = in.nextInt();
//            System.out.println(n);
            int[][] table = new int[n][3];
            for(int j=0;j<n;j++){
                for(int k=0;k<3;k++){
                    int s = in.nextInt();
                    table[j][k] = s;
                }
            }
            System.out.println(findTime(table));
        }

    }
}
