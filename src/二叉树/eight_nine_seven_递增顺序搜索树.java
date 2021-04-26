package 二叉树;

import org.junit.Test;

import utils.TreeNode;
import utils.TreeUtil;

/**
 * @author wjw
 * @date 2021/4/25 23:23
 */
public class eight_nine_seven_递增顺序搜索树 {

    @Test
    public void dfs(){
        TreeNode root = TreeUtil.deserialize("[5,1,7]");
        TreeUtil.printNode(root);
        TreeNode res = increasingBST(root);
        TreeUtil.printNode(res);
    }

    //方法1
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = dfs(root, null);
        return res;
    }
    public TreeNode dfs(TreeNode root, TreeNode last) {
        if(root == null) return last;

        TreeNode cur = dfs(root.left, root);
        root.left = null;
        root.right = dfs(root.right, last);

        return cur;
    }

    //方法2
    private TreeNode head;
    private TreeNode pre;
    public TreeNode cur;
    public TreeNode increasingBST1(TreeNode root) {
        pre = new TreeNode();
        head = pre;
        dfs(root);
        return head.right;
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        cur = new TreeNode();
        cur.val = root.val;
        cur.left = null;
        cur.right = null;
        pre.right = cur;
        pre = cur;
        dfs(root.right);
    }

}
