package 二叉树;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2019-11-29  18:26
 */
public class one_four_four_二叉树前序遍历 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        return list;
    }

    public void orderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }


    }
}
