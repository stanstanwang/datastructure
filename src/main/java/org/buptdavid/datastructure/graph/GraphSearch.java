package org.buptdavid.datastructure.graph;

import org.buptdavid.datastructure.queue.IQueue;
import org.buptdavid.datastructure.queue.Queue;

/**
 * 图的广度优先搜索和深度优先搜索实现
 *
 * @author weijielu
 * @see GraphNode
 * @see GraphSearchTest
 */
public class GraphSearch<T> {

    public StringBuffer searchPathDFS = new StringBuffer();
    public StringBuffer searchPathBFS = new StringBuffer();

    /**
     * 深度优先搜索实现, 使用递归
     *
     * @param root
     */
    public void searchDFS(GraphNode<T> root) {
        if (root == null) {
            return;
        }

        // visited root
        visit(searchPathDFS, root);
        // 关键点在于递归深入去遍历
        for (GraphNode<T> node : root.neighborList) {
            if (!node.visited) {
                searchDFS(node);
            }
        }
    }


    /**
     * 广度优先搜索实现,使用队列
     *
     * @param root
     */
    public void searchBFS(GraphNode<T> root) {
        IQueue<GraphNode<T>> queue = new Queue<GraphNode<T>>();

        // visited root
        visit(searchPathBFS, root);

        // 加到队列队尾
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            // 关键点在于遍历关联节点， 是在队尾后遍历的
            GraphNode<T> r = queue.dequeue();
            for (GraphNode<T> node : r.neighborList) {
                if (!node.visited) {

                    this.visit(searchPathBFS, node);

                    queue.enqueue(node);
                }
            }
        }
    }


    private void visit(StringBuffer searchPathBFS, GraphNode<T> root) {
        if (searchPathBFS.length() > 0) {
            searchPathBFS.append("->");
        }
        searchPathBFS.append(root.data.toString());
        root.visited = true;
    }

}
