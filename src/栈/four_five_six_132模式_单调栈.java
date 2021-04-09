package 栈;

import org.junit.Test;

import java.util.Stack;

/**
 * @create 2021-03-06  23:21
 */
public class four_five_six_132模式_单调栈 {

    @Test
    public void test(){
        int nums[] = {3, 1, 4, 2};
        System.out.println(find132pattern1(nums));
    }

    //暴力法
    public boolean find132pattern(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]<nums[j] && nums[j]>nums[k] && nums[i]<nums[k]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //三维的降维操作
    public boolean find132pattern1(int[] nums) {
        int length  = nums.length;
        //每个小标i包括自己以前的最小值
        int min = nums[0];
//        for(int i =1 ;i<length;i++){
//            min[i] = Math.min(min[i],nums[i]);
//        }

        for(int i=0;i<length;i++){
            min = Math.min(min,nums[i]); //找最小
            if(min == nums[i])continue;
            //找第三个值，从后往前 判断第三者是否满足
            for(int j=length-1;j>i;j--){
                if(nums[j]>min && nums[j]<nums[i]){
                    return true;
                }
            }
        }
        return false;
    }

    //单调栈
    class Solution {
        public boolean find132pattern2(int[] nums) {
            if (nums.length < 3)
                return false;
            Stack< Integer > stack = new Stack < > ();
            int[] min = new int[nums.length];
            min[0] = nums[0];
            for (int i = 1; i < nums.length; i++)
                min[i] = Math.min(min[i - 1], nums[i]);
            //nums = 【6，12，3，4，6，11，12】
            //min =  【6，12，3，3，3， 3， 3】
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] > min[j]) {
                    while (!stack.isEmpty() && stack.peek() <= min[j])
                        stack.pop();
                    if (!stack.isEmpty() && stack.peek() < nums[j])
                        return true;
                    stack.push(nums[j]);  //12 11
                }
            }
            return false;
        }

    }


}
