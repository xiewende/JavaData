package 二叉树;

import org.junit.Test;
import utils.TreeNode;
import utils.TreeUtil;


/**
 * @author
 * @date 2021/4/13 23:26
 */
public class seven_eight_three_二叉搜索树节点最小距离 {
//
    @Test
    public void test(){
        TreeNode root = TreeUtil.deserialize("[90,69,null,49,89,null,52]");
        TreeUtil.printNode(root);
        int re = minDiffInBST(root);
        System.out.println(re);
    }

    public int minDiffInBST(TreeNode root) {
        preVal = -0x3f3f3f3f;
        inorder(root);
        return res;
    }

    private int res = 0x3f3f3f3f;
    private int preVal;
    public void inorder(TreeNode root) {
        if (root == null) return ;
        inorder(root.left);
        res = Math.min(res, root.val - preVal);
        preVal = root.val;
        inorder(root.right);
    }
}
