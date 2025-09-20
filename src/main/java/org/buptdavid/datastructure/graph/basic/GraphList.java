package org.buptdavid.datastructure.graph.basic;

import java.util.*;

public class GraphList {
    private final List<List<Integer>> adjList; // 邻接表
    private final int numVertices;

    public GraphList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    // 添加无向边
    public void addEdge(int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    // 深度优先搜索 (DFS)
    public void dfs(int start) {
        boolean[] visited = new boolean[numVertices];
        dfsHelper(start, visited);
    }

    private void dfsHelper(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int neighbor : adjList.get(v)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited);
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
            for (int neighbor : adjList.get(v)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphList g = new GraphList(5);
        g.addEdge(0, 1);  // 添加示例图的边
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("\nDFS (邻接表):");
        g.dfs(0); // 输出 0 1 3 2 4
        System.out.println("\nBFS (邻接表):");
        g.bfs(0); // 输出 0 1 2 3 4
    }
}