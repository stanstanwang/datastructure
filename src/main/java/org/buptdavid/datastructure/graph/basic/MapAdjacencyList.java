package org.buptdavid.datastructure.graph.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 使用Map表示的邻接表
 */
public class MapAdjacencyList {
    // key: 顶点名称，value: 邻接顶点列表（兼容带权重图）
    private final Map<String, List<Edge>> adjacencyMap = new HashMap<>();

    // 添加边（无向图）
    public void addEdge(String source, String destination) {
        addDirectedEdge(source, destination);
        addDirectedEdge(destination, source);
    }

    // 添加有向边
    public void addDirectedEdge(String source, String destination) {
        adjacencyMap.computeIfAbsent(source, k -> new ArrayList<>())
                   .add(new Edge(destination));
    }

    // 添加带权重的边
    public void addWeightedEdge(String source, String dest, int weight) {
        adjacencyMap.computeIfAbsent(source, k -> new ArrayList<>())
                   .add(new Edge(dest, weight));
    }

    // 打印邻接表
    public void printList() {
        System.out.println("\n基于Map的邻接表：");
        adjacencyMap.forEach((vertex, edges) -> {
            System.out.print(vertex + " -> ");
            edges.forEach(e -> System.out.print(
                e.weight != 1 ? e.dest + "(" + e.weight + ") " : e.dest + " "));
            System.out.println();
        });
    }

    // 边对象（存储权重）
    private static class Edge {
        String dest;
        int weight;  // 默认权重为1（常规边）

        Edge(String dest) { this(dest, 1); }
        Edge(String dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        MapAdjacencyList graph = new MapAdjacencyList();
        // 添加无向边
        graph.addEdge("北京", "上海");
        graph.addEdge("北京", "广州");
        graph.addEdge("广州", "深圳");
        
        // 添加带权重的有向边（高铁票价）
        graph.addWeightedEdge("北京", "武汉", 500);
        graph.addDirectedEdge("武汉", "北京"); // 真实场景可能权重不同

        graph.printList();
    }
}