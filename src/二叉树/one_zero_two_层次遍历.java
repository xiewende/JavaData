package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @create 2019-09-21  17:49
 */
public class one_zero_two_层次遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            lists.add(list);

        }

        return lists;
    }
}
