package org.buptdavid.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * 图的广度优先搜索和深度优先搜索实现
 */
public class GraphSearch2<T> {

    StringBuilder sb = new StringBuilder();
    Consumer<GraphNode<T>> defaultConsumer = node -> {
        if (sb.length() > 0) {
            sb.append("->");
        }
        sb.append(node.data.toString());
    };


    /**
     * 深度优先搜索实现, 使用递归
     */
    public void searchDFS(GraphNode<T> root) {
        this.searchDFS(root, defaultConsumer);
    }

    public void searchDFS(GraphNode<T> root, Consumer<GraphNode<T>> consumer) {
        if (root == null) {
            return;
        }

        // 1. 先访问
        if (!root.visited) {
            consumer.accept(root);
            root.visited = true;
        }

        // 2. 然后递归遍历
        for (GraphNode<T> node : root.neighborList) {
            // 3. 判断是否访问过再递归
            // 因为图的节点会相互关联，所以要先判断是否访问过了再递归
            // 如果某个元素访问过，子元素也必定递归了的，所以不会楼
            if (!node.visited) {
                searchDFS(node, consumer);
            }
        }
    }


    /**
     * 广度优先搜索实现,使用队列的先进先出特性
     */
    public void searchBFS(GraphNode<T> root) {
        this.searchBFS(root, defaultConsumer);
    }
    public void searchBFS(GraphNode<T> root, Consumer<GraphNode<T>> consumer) {
        if (root == null) {
            return;
        }

        Queue<GraphNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            GraphNode<T> node = queue.poll();

            // 1. 先访问
            // 为什么要两次判断，可能没有遍历的元素多次都加了进来
            if (!node.visited) {
                consumer.accept(node);
                node.visited = true;
            }


            // 2. 再遍历
            for (GraphNode<T> childNode : node.neighborList) {
                // 3. 判断没有访问过再入队
                // 如果某个元素已经访问过了，子元素必定会入队了的，所以不会漏
                if (!childNode.visited) {
                    queue.offer(childNode);
                }
            }
        }
    }


    public String getSearchPath() {
        return sb.toString();
    }
}
