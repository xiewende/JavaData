package 滑动窗口;

import org.junit.Test;

/**
 * @create 2021-02-19  16:14
 */
public class six_seven_four_最长连续递增子序列 {

    @Test
    public void test(){
        int nums[] = {1,3,5,7};
        System.out.println(findLengthOfLCIS(nums));
    }

    public int findLengthOfLCIS(int[] nums) {
        int left=0;
        int right =1;
        int max = 0;
        while (right<nums.length){
            if(nums[right]>nums[right-1]){
                right++;
            }else {
                left = right;
                right++;
            }
            max = Math.max(max,right-left);
        }
        return max;
    }
}
