package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/11 10:47
 * @description：图，无权图的搜索算法
 * @modified By：
 */

public class Graph {

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


//        使用邻接链表进行图的广度优先搜索
        public void bfs(int s, int t) {
            if (s == t) return;
//        记录顶点是否被访问过
            boolean[] visited = new boolean[v];
//        起始顶点访问为true
            visited[s]=true;
//        待访问的顶点队列
            Queue<Integer> queue = new LinkedList<>();
//        添加起点
            queue.add(s);
//        记录路径
            int[] prev = new int[v];
//        初始化路径数组为-1，prev[w]记录的是，w是从哪个顶点访问过来的
            for (int i = 0; i < v; ++i) {
                prev[i] = -1;
            }
//        待访问队列不为空
            while (queue.size() != 0) {
//            取出下一代待访问订单
                int w = queue.poll();
//            遍历他的邻接链表，若未访问过，将其标记为访问，并将prev标及其来源
//            当遇到目标节点，跳出循环
                for (int i = 0; i < adj[w].size(); ++i) {
                    int q = adj[w].get(i);
                    if (!visited[q]) {
                        prev[q] = w;
                        if (q == t) {
//                        递归打印路径数组
                            print(prev, s, t);
                            return;
                        }
                        visited[q] = true;
                        queue.add(q);
                    }
                }
            }
        }

        private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
            if (prev[t] != -1 && t != s) {
                print(prev, s, prev[t]);
            }
            System.out.print(t + " ");
        }



//    深度优先搜索
        boolean found = false; // 全局变量或者类成员变量

        public void dfs(int s, int t) {
            found = false;
            boolean[] visited = new boolean[v];
            int[] prev = new int[v];
            for (int i = 0; i < v; ++i) {
                prev[i] = -1;
            }
            recurDfs(s, t, visited, prev);
            print(prev, s, t);
        }

        private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
            if (found) return;
            visited[w] = true;
            if (w == t) {
                found = true;
                return;
            }
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    recurDfs(q, t, visited, prev);
                }
            }
        }
}
