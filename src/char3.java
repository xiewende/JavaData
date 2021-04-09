
import java.util.ArrayList;
import java.util.List;

/**
 * @create 2019-09-03  18:12
 */
public class char3 {
    public static void main(String[] args) {


    }

   /* public List<TreeNode> allPossibleFBT(int N) {

        List<TreeNode> list = new ArrayList<>();

        if(N%2 == 0){
            return null;
        }
    `   return null;`

    }*/

   /* public  static int sum(int n){

        if(n == 1){
            return 1;
        }




    }*/

    public static List<Integer> find(TreeNode treeNode) {

        List<Integer> integerList = new ArrayList<>();
        if (treeNode.left == null && treeNode.right == null) {
            return integerList;
        } else {
            integerList.add(treeNode.val);
            find(treeNode.left);
            find(treeNode.right);
        }

        return integerList;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
