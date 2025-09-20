package org.buptdavid.datastructure.graph.basic;

import java.util.*;

public class GraphMatrix {
    private int[][] matrix; // 邻接矩阵
    private int numVertices;

    public GraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        matrix = new int[numVertices][numVertices];
    }

    // 添加无向边
    public void addEdge(int i, int j) {
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }

    // 深度优先搜索 (DFS)
    public void dfs(int start) {
        boolean[] visited = new boolean[numVertices];
        dfsHelper(start, visited);
    }

    private void dfsHelper(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " "); // 输出访问顺序
        for (int i = 0; i < numVertices; i++) {
            if (matrix[v][i] == 1 && !visited[i]) {
                dfsHelper(i, visited);
            }
        }
    }

    // 广度优先搜索 (BFS)
    public void bfs(int start) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int i = 0; i < numVertices; i++) {
                if (matrix[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphMatrix g = new GraphMatrix(5);
        g.addEdge(0, 1);  // 添加示例图的边
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("DFS (邻接矩阵):");
        g.dfs(0); // 输出 0 1 3 2 4
        System.out.println("\nBFS (邻接矩阵):");
        g.bfs(0); // 输出 0 1 2 3 4
    }
}