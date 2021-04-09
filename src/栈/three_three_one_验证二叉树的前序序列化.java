package 栈;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wjw
 * @date 2021/3/12 22:50
 */
public class three_three_one_验证二叉树的前序序列化 {

    @Test
    public void test(){
        String preorder = "9,3,12,#,#,1,#,#,22,#,6,#,#";
        boolean res = isValidSerialization2(preorder);
        System.out.println(res);
    }

    /**
     * -1 正在创建左子树
     *  0 正在创建右子树
     *  1 左右子树都完成
     *
     * 状态
     * stack:0
     *
     * 遇到# + top=-1表示左子树完成
     * 遇到# + top=0表示右子树完成
     * top = 1表示完成，int cur = pollLast()  ,   offerLast(pollLast + cur)
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) return true;
        if (preorder.length() == 1 && '#' == (preorder.charAt(0))) return true;
        if (preorder.length() != 1 && '#' == (preorder.charAt(0))) return false;

        String[] eles = preorder.split(",");
        Deque<Integer> stack = new LinkedList<>();
        stack.offerLast(-1);

        for (int i = 1; i < eles.length; i++) {
            if (stack.isEmpty()) return false;

            if (!"#".equals(eles[i])){
                // 左右子树未完成
                stack.offerLast(-1);
            }else if ("#".equals(eles[i])){
                stack.offerLast(stack.pollLast() + 1);
            }


            while (stack.peekLast() == 1 ){ //左右子树都完成
                if (stack.size() == 1 && i == eles.length - 1) return true;
                int cur = stack.pollLast();
                if(stack.isEmpty()) return false;   //提前结束，非法
                else {
                    stack.offerLast(stack.pollLast() + cur);
                }
            }
        }

        return false;
//        if (stack.isEmpty()) return false;
//        else return stack.peekLast() == 1;
    }

    public boolean isValidSerialization2(String preorder) {
        int slot=1;
        if(preorder==null) return false;
        char[] s = preorder.toCharArray();
        int n = s.length;
        if(n==1&&s[0]=='#') return true;
        for(int i=1;i<n;i++){
            if(s[i]==',') {
                if(s[i-1]!='#'){
                    if(slot<=0) return false;
                    slot++;
                } else {
                    slot--;
                }
            }
            if(i==n-1){
                if(s[i]=='#') slot--;
                else slot++;
            }
        }
        if(slot==0) return true;
        else return false;
    }
}
