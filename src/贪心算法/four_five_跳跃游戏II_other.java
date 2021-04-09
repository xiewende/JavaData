/**
 * @author wjw
 * @date 2020/3/20 22:06
 */
package 贪心算法;

import org.junit.Test;

public class four_five_跳跃游戏II_other {
    @Test
    public void test(){
        int[] nums = {2,3,1,1,4};
        int res = jump(nums);
        System.out.println(res);
    }

    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
