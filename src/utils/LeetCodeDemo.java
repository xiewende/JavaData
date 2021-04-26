package utils;

import org.junit.Test;

/**
 * 以leetcode 226.翻转二叉树 举例
 * @author wjw
 * @date 2021/4/25 23:53
 */
public class LeetCodeDemo {

    @Test
    public void test() {
        TreeNode root = TreeUtil.deserialize("[4,2,7,1,3,6,9]");  // 使用deserialize方法从leetcode用例中获得一棵树的root节点
        TreeUtil.printNode(root);                                        // 使用printNode方法可以打印一棵树

        //完成leetcode题目并打印运行结果
        TreeNode res = invertTree(root);
        TreeUtil.printNode(res);

        String serRes = TreeUtil.serialize(root);                       // 使用serialize可以从root节点序列化为leetcode格式的数组
        System.out.println(serRes);
    }

    //完成力扣题目给出的函数
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        return root;
    }
}
