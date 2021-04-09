package 二叉树;

import org.junit.Test;

/**
 * @create 2021-03-14  19:03
 */
public class one_zero_five从前序与中序遍历序列构造二叉树 {

    @Test
    public void test(){
//        String str = "abcdef";
//        int index = str.indexOf('c'); // 2
//        System.out.println(index);
//        System.out.println(str.substring(index,str.length()-1)); //左闭右开

        int preorder[] = {3,9,20,15,7};
        int inorder[] = {9,3,15,20,7};
        TreeNode node = buildTree(preorder,inorder);
        System.out.println(node.val);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int inorderSize = inorder.length;
        int preorderSize = preorder.length;

        if(inorderSize==0 || preorderSize==0){
            return null;
        }

        int rootNum = preorder[0]; //根节点值
        TreeNode root = new TreeNode(rootNum);
        //遍历找位置
        int position = 0;
        while(inorder[position]!=rootNum){
            position++;
        }
        //先搞定中序
        //右子树的中序
        int nextInorderOfRightSize = inorderSize - position - 1;
        int nextInorderOfRight[] = new int[nextInorderOfRightSize];
        int index1 = 0;
        for(int i = position+1;i<inorderSize;i++){
            nextInorderOfRight[index1++] = inorder[i];
        }

        //左子树的中序
        int nextinorderOfLeftSize = position;
        int nextinorderOfLeft[] = new int[nextinorderOfLeftSize];
        int index2 = 0;
        for(int i=0 ;i<nextinorderOfLeftSize;i++){
            nextinorderOfLeft[index2++] = inorder[i];
        }
        //再搞定前序
        //左子树的前序
        int nextPreorderOfLeftSize = nextinorderOfLeftSize; //长度和中序一样
        int nextPreorderOfLeft[] = new int[nextPreorderOfLeftSize];
        int index3 = 0;
        for(int i=1;i<=nextPreorderOfLeftSize;i++){
            nextPreorderOfLeft[index3++] = preorder[i];
        }

        //右子树的前序
        int nextPreorderOfRightSize = preorderSize - nextPreorderOfLeftSize - 1;
        int nextPreorderOfRight[] = new int[nextPreorderOfRightSize];
        int index4 = 0;
        for(int i = nextPreorderOfLeftSize+1;i<preorderSize;i++){
            nextPreorderOfRight[index4++] = preorder[i];
        }


        root.left = buildTree(nextPreorderOfLeft, nextinorderOfLeft);
        root.right = buildTree(nextPreorderOfRight, nextInorderOfRight);

        return root;

    }
}


