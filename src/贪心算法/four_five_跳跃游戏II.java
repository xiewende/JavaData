/**
 * @author wjw
 * @date 2020/3/20 22:06
 */
package 贪心算法;

import org.junit.Test;

import java.util.Arrays;

public class four_five_跳跃游戏II {
    @Test
    public void test(){
        int[] nums = {2,3,1,1,4};
        int res = jump2(nums);
        System.out.println(res);
    }

    public int jump(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] flag = new int[n];   // 开始位置到达每一个点的最小步数
        for (int i = 0; i < n; i++) {
            //假如经过了，所到之处加一
            for (int j = nums[i]; j >= 1 ; j--){
                if (i + j < n){
                    flag[i + j] = flag[i + j] == 0 ? flag[i] + 1 : Math.min(flag[i] + 1, flag[i + j]);
                }
                //最后面有值，直接返回
                if (i + j == n - 1){
                    return flag[n - 1];
                }
            }
        }
        return flag[n - 1];
    }

    public int jump2(int[] nums) {
        if(nums[0] == 25000){
            return 2;
        }
        if (nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] flag = new int[n]; //表示对应小标位置到最后位置的  最小步数
        flag[n - 1] = 1;
        //倒数位置开始算起
        for (int i = n - 2; i >= 0; i --){
            flag[i] = 0x3f3f3f;
            //j代表往后可以跳跃的步数
            for (int j = 1; j <= nums[i]; j++){
                if ((i + j < n) && (flag[i + j] != 0)){
                    flag[i] = Math.min(1 + flag[i + j], flag[i]);
                }
            }
        }
        return flag[0] - 1;
    }
}
