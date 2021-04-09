package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2019-10-09  17:19
 */
public class two_five_seven_二叉树路劲 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }

        List<String> releft = binaryTreePaths(root.left);
        if (releft != null) {
            for (int i = 0; i < releft.size(); i++) {
                result.add(String.valueOf(root.val) + "->" + releft.get(i));
            }
        }

        List<String> reright = binaryTreePaths(root.right);
        if (reright != null) {
            for (int i = 0; i < reright.size(); i++) {
                result.add(String.valueOf(root.val) + "->" + reright.get(i));
            }
        }


        return result;
    }
}
