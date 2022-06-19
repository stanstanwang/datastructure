package org.buptdavid.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * @author stan
 * @date 2022/6/19
 */
public class TreeSearch2<T> {

    StringBuilder sb = new StringBuilder();
    Consumer<TreeNode<T>> defaultConsumer = node -> {
        if (sb.length() > 0) {
            sb.append("->");
        }
        sb.append(node.data.toString());
    };

    public void levelOrder(TreeNode<T> root) {
        this.levelOrder(root, defaultConsumer);
    }

    public void levelOrder(TreeNode<T> root, Consumer<TreeNode<T>> consumer) {
        if (root == null) {
            return;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 1. 先访问
            TreeNode<T> node = queue.poll();
            consumer.accept(node);

            // 2. 遍历
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public String getSearchPath() {
        return sb.toString();
    }

}
