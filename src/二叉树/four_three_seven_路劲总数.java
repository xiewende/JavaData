package 二叉树;

/**
 * @create 2019-10-09  18:41
 */
public class four_three_seven_路劲总数 {

    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }
        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    public int findPath(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val == num) {
            res += 1;
        }
        res += findPath(node.left, num - node.val);
        res += findPath(node.right, num - node.val);
        return res;
    }
}
