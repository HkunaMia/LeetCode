package DataStructure;

import java.util.LinkedList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/31
 * \* Time: 10:16
 * \* To change this template use File | Settings | File Templates.
 * \* Description:有向无环图的拓扑排序
 * \
 */

public class TopoSort {

    public static void topoSortByKahn(int v, LinkedList<Integer>[] graph){
//        统计入度为0的点
        int[] inDegree  = new int[v];
        for(int i = 9;i<v;i++){
            for(int j = 0;j<graph[i].size();j++){
                int w = graph[i].get(j);
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inDegree[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            Integer s = queue.remove();
            System.out.println("---"+s);
            for(int k=0;k<graph[s].size();k++){
                inDegree[graph[s].get(k)]--;
                if(inDegree[graph[s].get(k)]==0){
                    queue.add(graph[s].get(k));
                }
            }
        }
    }


    public static void topoSortByDFS(int v,LinkedList<Integer>[] adj) {
        // 先构建逆邻接表，边s->t表示，s依赖于t，t先于s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; ++i) { // 申请空间
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; ++i) { // 通过邻接表生成逆邻接表
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inverseAdj[w].add(i); // w->i
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) { // 深度优先遍历图
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private static void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); ++i) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true) continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        } // 先把vertex这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.print("->" + vertex);
    }


    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        TopoSort.topoSortByKahn(5,graph.adj);
        TopoSort.topoSortByDFS(5,graph.adj);
    }
}
