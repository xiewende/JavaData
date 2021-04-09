/**
 * @author wjw
 * @date 2020/3/20 21:30
 */
package 贪心算法;

import org.junit.Test;

public class five_five_跳跃游戏 {
    @Test
    public void test(){
        int[] nums = {2,0};
        boolean res = canJump(nums);
        System.out.println(res);
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 0){
            return false;
        }
        int n = nums.length;
        boolean[] flag = new boolean[n];
        flag[n - 1] = true;
        //i代表当前填的boolean数组位置
        for (int i = n - 2; i >= 0; i --){
            //j代表往后可以跳跃的步数
            for (int j = nums[i]; j >= 1; j--){
                if ((i + j <= n - 1) && flag[i + j]){
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[0];
    }
}
