package ZiJie;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/8/23
 * \* Time: 10:18
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

public class Solution4 {

    static class Graph{
        // 无向图
        private int v; // 顶点的个数
        public LinkedList<Integer> adj[]; // 邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { // 无向图一条边存两次
            adj[s].add(t);
            adj[t].add(s);
        }
    }


    public static void creatGraph(int[][] edges,int m,Graph graph){
        for(int i = 0;i<m;i++){
            for(int j=i+1;j<m;j++){
                if(edges[j][0] < edges[i][0] && edges[i][0] < edges[j][1]  && edges[j][1] < edges[i][1]){
                    graph.addEdge(i,j);
                }
                if(edges[j][0] > edges[i][0] && edges[j][0] <edges[i][1] && edges[j][1] > edges[i][1]){
                    graph.addEdge(i,j);
                }
            }
        }
    }

    static int count = 0;
    public static boolean isHaveLoop(Graph graph, int n) {
        boolean[] visited = new boolean[n];//定义一个节点状态数组  判断是否访问过
        int[] a = {0};
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {//如果没有进行访问  则进行深度优先搜索回溯
                dfsCycle(graph.adj, i, -1, visited, a);//引用传递  函数内部修改值后退出函数可见
//                System.out.println(a[0]);

                if (a[0] == 1) {//只要有一次i循环时存在环路那就直接提前返回，说明存在环
                    return false;
                }
                if(count!=n){
                    return false;
                }
            }
        }
        if(a[0] !=1){
            return true;
        }
        return false;
    }


    private static void dfsCycle(List<Integer>[] adj, int current, int parent, boolean[] visited, int[] flag) {
        visited[current] = true;//首先 访问当前节点   并进行标记
        count++;
        List<Integer> list = adj[current];  //获取到当前节点能够到达的所有节点
        for (Integer can : list) {
            if (visited[can] == false) {//如果节点没有被访问过
                dfsCycle(adj, can, current, visited, flag);//当前节点就是父节点，循环的节点就是子节点
            } else if (can != parent) {// 在节点被访问过的情况下 如果该节点不等于父节点  ，说明有环
                flag[0] = 1;
            }
            //循环节点等于父节点的情况直接跳过，不用处理
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0;i<n;i++){
            int num = Integer.parseInt(in.nextLine());
            int[][] edges = new int[num][num];
            for(int j = 0;j<num;j++){
                String[] s = in.nextLine().split(" ");
                edges[j][0] = Integer.parseInt(s[0]);
                edges[j][1] = Integer.parseInt(s[1]);
            }
            Graph graph = new Graph(num);
            creatGraph(edges,num,graph);
            count = 0;
            boolean haveLoop = isHaveLoop(graph, num);
            System.out.println(count);
            if(haveLoop){
                System.out.println("Yes");
            }else{
                System.out.println("NO");
            }

        }
    }
}
