package DataStructure;

import java.util.LinkedList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/31
 * \* Time: 11:01
 * \* To change this template use File | Settings | File Templates.
 * \* Description:有权有向图
 * \
 */

public class WeightGraph {

    private LinkedList<Edge> adj[]; // 邻接表
    private int v; // 顶点个数

        public WeightGraph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                this.adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t, int w) { // 添加一条边
            this.adj[s].add(new Edge(s, t, w));
        }

        private class Edge {
            public int sid; // 边的起始顶点编号
            public int tid; // 边的终止顶点编号
            public int w; // 权重
            public Edge(int sid, int tid, int w) {
                this.sid = sid;
                this.tid = tid;
                this.w = w;
            }
        }
        // 下面这个类是为了dijkstra实现用的
        private class Vertex {
            public int id; // 顶点编号ID
            public int dist; // 从起始顶点到这个顶点的距离
            public Vertex(int id, int dist) {
                this.id = id;
                this.dist = dist;
            }
        }

}
